package com.example.islamquiznl.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.islamquiznl.data.Difficulty
import com.example.islamquiznl.data.Question
import com.example.islamquiznl.data.QuestionBankNl
import com.example.islamquiznl.utils.ChallengeCodeUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ChallengeState(
    val code: String                 = "",
    val questions: List<Question>    = emptyList(),
    val currentIndex: Int            = 0,
    val selectedAnswer: Int?         = null,
    val isAnswered: Boolean          = false,
    val isCorrect: Boolean           = false,
    val isFinished: Boolean          = false,
    val correctCount: Int            = 0,
    val startTimeMs: Long            = 0L,
    val elapsedMs: Long              = 0L
) {
    val currentQuestion: Question? get() = questions.getOrNull(currentIndex)
    val questionNumber: Int        get() = currentIndex + 1
    val totalQuestions: Int        get() = questions.size
}

class ChallengeViewModel(application: Application) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(ChallengeState())
    val state: StateFlow<ChallengeState> = _state.asStateFlow()

    /** Bouw challenge-vragenlijst op basis van code als seed. */
    fun startChallenge(code: String) {
        val normalized = ChallengeCodeUtils.normalize(code)
        val seed       = ChallengeCodeUtils.toSeed(normalized)
        val rng        = java.util.Random(seed)

        val all = QuestionBankNl.questions

        // Splits per moeilijkheid
        val easy   = all.filter { it.difficulty == Difficulty.EASY   }.toMutableList()
        val medium = all.filter { it.difficulty == Difficulty.MEDIUM }.toMutableList()
        val hard   = all.filter { it.difficulty == Difficulty.HARD   }.toMutableList()

        // Shuffle deterministisch met seed
        fun <T> MutableList<T>.seededShuffle(): List<T> {
            for (i in size - 1 downTo 1) {
                val j = (rng.nextInt(i + 1))
                val tmp = this[i]; this[i] = this[j]; this[j] = tmp
            }
            return this.toList()
        }

        val shuffledEasy   = easy.seededShuffle().take(10)
        val shuffledMedium = medium.seededShuffle().take(20)
        val shuffledHard   = hard.seededShuffle().take(20)

        // Vul aan als te weinig
        val usedIds = (shuffledEasy + shuffledMedium + shuffledHard).map { it.id }.toMutableSet()
        fun fillUp(list: List<Question>, needed: Int): List<Question> {
            if (list.size >= needed) return list
            val extra = all.filter { it.id !in usedIds }.seededShuffle().take(needed - list.size)
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
            startTimeMs = System.currentTimeMillis()
        )
    }

    fun selectAnswer(index: Int) {
        val s = _state.value
        if (s.isAnswered) return
        val q = s.currentQuestion ?: return

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
            // Alle vragen afgerond
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
                isCorrect      = false
            )
        }
    }

    fun resetWithSameCode() {
        val code = _state.value.code
        startChallenge(code)
    }
}
