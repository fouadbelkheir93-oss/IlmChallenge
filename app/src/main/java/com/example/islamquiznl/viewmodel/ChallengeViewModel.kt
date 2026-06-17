package com.example.islamquiznl.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.islamquiznl.data.Difficulty
import com.example.islamquiznl.data.Question
import com.example.islamquiznl.data.QuestionBankNl
import com.example.islamquiznl.utils.ChallengeCodeUtils
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ChallengeState(
    val code: String              = "",
    val questions: List<Question> = emptyList(),
    val currentIndex: Int         = 0,
    val selectedAnswer: Int?      = null,
    val isAnswered: Boolean       = false,
    val isCorrect: Boolean        = false,
    val isFinished: Boolean       = false,
    val correctCount: Int         = 0,
    val startTimeMs: Long         = 0L,
    val elapsedMs: Long           = 0L,
    val timerSeconds: Int         = 30
) {
    val currentQuestion: Question? get() = questions.getOrNull(currentIndex)
    val questionNumber: Int        get() = currentIndex + 1
    val totalQuestions: Int        get() = questions.size
}

class ChallengeViewModel(application: Application) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(ChallengeState())
    val state: StateFlow<ChallengeState> = _state.asStateFlow()

    private var timerJob: Job? = null

    private fun seededShuffle(list: List<Question>, rng: java.util.Random): List<Question> {
        val result = list.toMutableList()
        for (i in result.size - 1 downTo 1) {
            val j = rng.nextInt(i + 1)
            val tmp = result[i]; result[i] = result[j]; result[j] = tmp
        }
        return result
    }

    fun startChallenge(code: String) {
        timerJob?.cancel()
        val normalized = ChallengeCodeUtils.normalize(code)
        val seed       = ChallengeCodeUtils.toSeed(normalized)
        val rng        = java.util.Random(seed)

        val all    = QuestionBankNl.questions
        val easy   = all.filter { it.difficulty == Difficulty.EASY   }
        val medium = all.filter { it.difficulty == Difficulty.MEDIUM }
        val hard   = all.filter { it.difficulty == Difficulty.HARD   }

        val shuffledEasy   = seededShuffle(easy,   rng).take(10)
        val shuffledMedium = seededShuffle(medium, rng).take(20)
        val shuffledHard   = seededShuffle(hard,   rng).take(20)

        val usedIds = (shuffledEasy + shuffledMedium + shuffledHard).map { it.id }.toMutableSet()

        fun fillUp(list: List<Question>, needed: Int): List<Question> {
            if (list.size >= needed) return list
            val extra = seededShuffle(all.filter { it.id !in usedIds }, rng).take(needed - list.size)
            usedIds.addAll(extra.map { it.id })
            return list + extra
        }

        val finalEasy   = fillUp(shuffledEasy,   10)
        val finalMedium = fillUp(shuffledMedium, 20)
        val finalHard   = fillUp(shuffledHard,   20)

        val questions = (finalEasy + finalMedium + finalHard).take(50)

        _state.value = ChallengeState(
            code        = normalized,
            questions   = questions,
            startTimeMs = System.currentTimeMillis(),
            timerSeconds = 30
        )
        startTimer()
    }

    fun selectAnswer(index: Int) {
        val s = _state.value
        if (s.isAnswered) return
        val q = s.currentQuestion ?: return
        timerJob?.cancel()

        val correct = index == q.correctAnswerIndex
        val elapsed = System.currentTimeMillis() - s.startTimeMs

        _state.value = s.copy(
            selectedAnswer = index,
            isAnswered     = true,
            isCorrect      = correct,
            correctCount   = if (correct) s.correctCount + 1 else s.correctCount,
            isFinished     = !correct,
            elapsedMs      = if (!correct) elapsed else s.elapsedMs
        )
    }

    fun nextQuestion() {
        val s = _state.value
        if (!s.isCorrect || s.isFinished) return

        val nextIndex = s.currentIndex + 1
        if (nextIndex >= s.questions.size) {
            _state.value = s.copy(
                currentIndex = nextIndex,
                isFinished   = true,
                elapsedMs    = System.currentTimeMillis() - s.startTimeMs
            )
        } else {
            _state.value = s.copy(
                currentIndex   = nextIndex,
                selectedAnswer = null,
                isAnswered     = false,
                isCorrect      = false,
                timerSeconds   = 30
            )
            startTimer()
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            var seconds = 30
            while (seconds > 0) {
                delay(1_000)
                seconds--
                _state.value = _state.value.copy(timerSeconds = seconds)
            }
            val s = _state.value
            if (!s.isAnswered) {
                _state.value = s.copy(
                    isAnswered = true,
                    isCorrect  = false,
                    isFinished = true,
                    elapsedMs  = System.currentTimeMillis() - s.startTimeMs
                )
            }
        }
    }
}
