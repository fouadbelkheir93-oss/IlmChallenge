package com.example.islamquiznl.repository

import com.example.islamquiznl.data.Difficulty
import com.example.islamquiznl.data.Question
import com.example.islamquiznl.data.QuestionBankNl
import com.example.islamquiznl.data.QuizCategory

class QuizRepository {

    private val allQuestions: List<Question> = QuestionBankNl.questions

    /**
     * Build a safe 15-question round: 5 EASY, 5 MEDIUM, 5 HARD.
     *
     * For category quizzes we first prefer questions from the selected category. If a category
     * does not contain enough questions for a difficulty, we fill the missing spots with questions
     * from other categories of the same difficulty. This keeps the app stable while the test bank
     * still has only 100 questions.
     */
    fun buildRound(category: QuizCategory? = null): List<Question> {
        val usedIds = mutableSetOf<Int>()

        fun pickTier(difficulty: Difficulty, count: Int): List<Question> {
            val preferred = allQuestions
                .filter { question ->
                    question.difficulty == difficulty &&
                        question.id !in usedIds &&
                        (category == null || question.category == category)
                }
                .shuffled()

            val fallback = allQuestions
                .filter { question -> question.difficulty == difficulty && question.id !in usedIds }
                .shuffled()

            val selected = (preferred + fallback)
                .distinctBy { it.id }
                .take(count)

            usedIds.addAll(selected.map { it.id })
            return selected
        }

        val round = buildList {
            addAll(pickTier(Difficulty.EASY, 5))
            addAll(pickTier(Difficulty.MEDIUM, 5))
            addAll(pickTier(Difficulty.HARD, 5))
        }

        // Extra safety: if the bank ever has too few questions for a tier, fill any missing slots
        // with unused questions from the whole bank so the UI never opens an empty/short round.
        if (round.size >= 15) return round.take(15)

        val fillers = allQuestions
            .filter { it.id !in usedIds }
            .shuffled()
            .take(15 - round.size)

        return (round + fillers).take(15)
    }

    /** Daily question: deterministic based on day-of-year so it is stable within one day. */
    fun getDailyQuestion(): Question {
        val dayOfYear = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_YEAR)
        return allQuestions[dayOfYear % allQuestions.size]
    }

    fun getCategories(): List<QuizCategory> = QuizCategory.entries.toList()

    fun getQuestionsByCategory(category: QuizCategory): List<Question> =
        allQuestions.filter { it.category == category }

    /** Replacement question of the same difficulty; exclude already-used ids. */
    fun getReplacement(
        difficulty: Difficulty,
        excludeIds: Set<Int>,
        preferCategory: QuizCategory? = null
    ): Question? {
        val candidates = allQuestions
            .filter { it.difficulty == difficulty && it.id !in excludeIds }
        val preferred = if (preferCategory != null) candidates.filter { it.category == preferCategory } else emptyList()
        return (preferred.ifEmpty { candidates }).randomOrNull()
    }
}
