package com.example.islamquiznl.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.islamquiznl.data.Question
import com.example.islamquiznl.data.QuizCategory
import com.example.islamquiznl.repository.QuizRepository
import com.example.islamquiznl.storage.AppPreferences
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

// Index 0 = geen punten nog, index 1 = vraag 1 = 100 punten, ... index 15 = vraag 15 = 1.000.000
val SCORE_LADDER = listOf(
    0, 100, 200, 300, 500, 1_000, 2_000, 4_000, 8_000,
    16_000, 32_000, 64_000, 125_000, 250_000, 500_000, 1_000_000
)

fun formatScore(score: Int): String = when {
    score >= 1_000_000 -> "1.000.000"
    score >= 1_000     -> "${score / 1_000}.${String.format("%03d", score % 1_000)}"
    else               -> score.toString()
}

data class QuizState(
    val questions: List<Question>   = emptyList(),
    val currentIndex: Int           = 0,      // 0-based: vraag 1 = index 0
    val selectedAnswer: Int?        = null,
    val isAnswered: Boolean         = false,
    val score: Int                  = 0,
    val correctCount: Int           = 0,
    val isGameOver: Boolean         = false,
    val isWon: Boolean              = false,
    val showExplanation: Boolean    = false,
    val fiftyFiftyUsed: Boolean     = false,
    val hintUsed: Boolean           = false,
    val imamUsed: Boolean           = false,
    val skipUsed: Boolean           = false,
    val hiddenAnswers: Set<Int>     = emptySet(),
    val showHint: Boolean           = false,
    val hintText: String            = "",
    val showImam: Boolean           = false,
    val imamText: String            = "",
    val timerSeconds: Int           = 60,
    val usedIds: Set<Int>           = emptySet()
) {
    val currentQuestion: Question? get() = questions.getOrNull(currentIndex)
    // vraag 1 = questionNumber 1, bij index 0
    val questionNumber: Int        get() = currentIndex + 1
    // punten die de speler verdient als hij de HUIDIGE vraag goed beantwoordt
    val currentLevelPoints: Int    get() = SCORE_LADDER.getOrElse(currentIndex + 1) { 1_000_000 }
}

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = QuizRepository()
    val prefs        = AppPreferences(application)

    private val _state = MutableStateFlow(QuizState())
    val state: StateFlow<QuizState> = _state.asStateFlow()

    private val _bestScore = MutableStateFlow(0)
    val bestScore: StateFlow<Int> = _bestScore.asStateFlow()

    private var timerJob: Job? = null

    init {
        viewModelScope.launch { prefs.bestScore.collect { _bestScore.value = it } }
    }

    fun startQuiz(category: QuizCategory? = null) {
        timerJob?.cancel()
        val questions = repo.buildRound(category)
        val usedIds   = questions.map { it.id }.toSet()
        _state.value  = QuizState(questions = questions, usedIds = usedIds, timerSeconds = 60)
        maybeStartTimer()
    }

    fun selectAnswer(index: Int) {
        val s = _state.value
        if (s.isAnswered) return
        val q = s.currentQuestion ?: return
        timerJob?.cancel()

        val correct    = index == q.correctAnswerIndex
        val newCorrect = if (correct) s.correctCount + 1 else s.correctCount
        // Score = punten van de huidige vraag als goed
        val newScore   = if (correct) SCORE_LADDER.getOrElse(s.currentIndex + 1) { s.score } else s.score
        val gameOver   = !correct
        val won        = correct && s.currentIndex == 14

        _state.value = s.copy(
            selectedAnswer  = index,
            isAnswered      = true,
            showExplanation = true,
            score           = if (correct) newScore else s.score,
            correctCount    = newCorrect,
            isGameOver      = gameOver,
            isWon           = won
        )

        if (gameOver || won) {
            val finalScore = if (correct) newScore else s.score
            viewModelScope.launch { prefs.saveBestScore(finalScore, newCorrect) }
        }
    }

    fun nextQuestion() {
        val s = _state.value
        if (s.isGameOver || s.isWon) return
        _state.value = s.copy(
            currentIndex    = s.currentIndex + 1,
            selectedAnswer  = null,
            isAnswered      = false,
            showExplanation = false,
            hiddenAnswers   = emptySet(),
            showHint        = false,
            showImam        = false,
            timerSeconds    = 60
        )
        maybeStartTimer()
    }

    fun useFiftyFifty() {
        val s = _state.value
        if (s.fiftyFiftyUsed || s.isAnswered) return
        val q = s.currentQuestion ?: return
        val wrong = (0..3).filter { it != q.correctAnswerIndex }.shuffled().take(2).toSet()
        _state.value = s.copy(fiftyFiftyUsed = true, hiddenAnswers = wrong)
    }

    fun useHint() {
        val s = _state.value
        if (s.hintUsed || s.isAnswered) return
        val q = s.currentQuestion ?: return
        _state.value = s.copy(hintUsed = true, showHint = true, hintText = q.hint)
    }

    fun useImam() {
        val s = _state.value
        if (s.imamUsed || s.isAnswered) return
        val q = s.currentQuestion ?: return
        _state.value = s.copy(imamUsed = true, showImam = true, imamText = q.extraHint)
    }

    fun useSkip() {
        val s = _state.value
        if (s.skipUsed || s.isAnswered) return
        val q = s.currentQuestion ?: return
        timerJob?.cancel()
        val replacement = repo.getReplacement(q.difficulty, s.usedIds, q.category) ?: return
        val newQuestions = s.questions.toMutableList().also { it[s.currentIndex] = replacement }
        _state.value = s.copy(
            questions       = newQuestions,
            skipUsed        = true,
            selectedAnswer  = null,
            isAnswered      = false,
            showExplanation = false,
            hiddenAnswers   = emptySet(),
            showHint        = false,
            showImam        = false,
            usedIds         = s.usedIds + replacement.id,
            timerSeconds    = 60
        )
        maybeStartTimer()
    }

    fun dismissHint() { _state.value = _state.value.copy(showHint = false) }
    fun dismissImam() { _state.value = _state.value.copy(showImam = false) }

    private fun maybeStartTimer() {
        viewModelScope.launch {
            // Standaard aan (timerEnabled default = false in prefs, maar we zetten het nu aan)
            if (prefs.timerEnabled.first()) startTimer()
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            var seconds = 60
            while (seconds > 0) {
                delay(1_000)
                seconds--
                _state.value = _state.value.copy(timerSeconds = seconds)
            }
            val s = _state.value
            if (!s.isAnswered) {
                _state.value = s.copy(isAnswered = true, showExplanation = true, isGameOver = true)
                prefs.saveBestScore(s.score, s.correctCount)
            }
        }
    }

    fun resetBestScore()             { viewModelScope.launch { prefs.resetBestScore() } }
    fun setTimerEnabled(on: Boolean) { viewModelScope.launch { prefs.setTimerEnabled(on) } }
    fun setDarkMode(on: Boolean)     { viewModelScope.launch { prefs.setDarkMode(on) } }

    // ── Daily ──────────────────────────────────────────────────────────────────
    private val _dailyQuestion = MutableStateFlow<Question?>(null)
    val dailyQuestion: StateFlow<Question?> = _dailyQuestion.asStateFlow()
    private val _dailyAnswered = MutableStateFlow(false)
    val dailyAnswered: StateFlow<Boolean> = _dailyAnswered.asStateFlow()
    private val _dailySelected = MutableStateFlow<Int?>(null)
    val dailySelected: StateFlow<Int?> = _dailySelected.asStateFlow()

    fun loadDailyQuestion() {
        _dailyQuestion.value = repo.getDailyQuestion()
        _dailyAnswered.value = false
        _dailySelected.value = null
    }

    fun answerDaily(index: Int) {
        if (_dailyAnswered.value) return
        _dailySelected.value = index
        _dailyAnswered.value = true
    }
}
