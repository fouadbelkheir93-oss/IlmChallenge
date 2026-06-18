package com.example.islamquiznl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.islamquiznl.data.QuizCategory
import com.example.islamquiznl.ui.screens.*
import com.example.islamquiznl.viewmodel.ChallengeViewModel
import com.example.islamquiznl.viewmodel.QuizViewModel

@Composable
fun AppNavigation(vm: QuizViewModel = viewModel()) {
    val navController   = rememberNavController()
    val state           by vm.state.collectAsState()
    val challengeVm: ChallengeViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.HOME) {

        // ── Home ───────────────────────────────────────────────────────────────
        composable(Routes.HOME) {
            val bestScore by vm.bestScore.collectAsState()
            HomeScreen(
                onStartQuiz     = { vm.startQuiz(); navController.navigate(Routes.QUIZ) },
                onCategories    = { navController.navigate(Routes.CATEGORIES) },
                onDailyQuestion = { navController.navigate(Routes.FRIEND_CHALLENGE) },
                onSettings      = { navController.navigate(Routes.SETTINGS) },
                onAbout         = { navController.navigate(Routes.ABOUT) },
                bestScore       = bestScore
            )
        }

        // ── Solo quiz ──────────────────────────────────────────────────────────
        composable(Routes.QUIZ) {
            QuizScreen(
                vm        = vm,
                onGameEnd = { navController.navigate(Routes.RESULT) { popUpTo(Routes.QUIZ) { inclusive = true } } },
                onBack    = { navController.popBackStack() }
            )
        }

        composable(
            route     = Routes.QUIZ_CATEGORY,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { back ->
            val cat = back.arguments?.getString("category")
                ?.let { runCatching { QuizCategory.valueOf(it) }.getOrNull() }
            LaunchedEffect(cat) { vm.startQuiz(cat) }
            if (state.questions.isNotEmpty()) {
                QuizScreen(
                    vm        = vm,
                    onGameEnd = { navController.navigate(Routes.RESULT) { popUpTo(Routes.QUIZ_CATEGORY) { inclusive = true } } },
                    onBack    = { navController.popBackStack() }
                )
            }
        }

        composable(Routes.RESULT) {
            ResultScreen(
                vm          = vm,
                onPlayAgain = { vm.startQuiz(); navController.navigate(Routes.QUIZ) { popUpTo(Routes.HOME) } },
                onHome      = { navController.navigate(Routes.HOME) { popUpTo(Routes.HOME) { inclusive = true } } }
            )
        }

        composable(Routes.CATEGORIES) {
            CategoryScreen(
                onCategorySelected = { cat -> navController.navigate("quiz/${cat.name}") },
                onBack             = { navController.popBackStack() }
            )
        }

        composable(Routes.DAILY_QUESTION) {
            DailyQuestionScreen(vm = vm, onBack = { navController.popBackStack() })
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(vm = vm, onBack = { navController.popBackStack() })
        }

        composable(Routes.ABOUT) {
            AboutScreen(onBack = { navController.popBackStack() })
        }

        // ── Challenge ──────────────────────────────────────────────────────────
        composable(Routes.FRIEND_CHALLENGE) {
            FriendChallengeScreen(
                onStartChallenge = { code ->
                    navController.navigate("challenge_quiz/$code")
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route     = Routes.CHALLENGE_QUIZ,
            arguments = listOf(navArgument("code") { type = NavType.StringType })
        ) { back ->
            val code = back.arguments?.getString("code") ?: ""
            LaunchedEffect(code) { challengeVm.startChallenge(code) }
            ChallengeQuizScreen(
                vm         = challengeVm,
                onFinished = {
                    navController.navigate(Routes.CHALLENGE_RESULT) {
                        popUpTo(Routes.FRIEND_CHALLENGE)
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.CHALLENGE_RESULT) {
            ChallengeResultScreen(
                vm        = challengeVm,
                onNewCode = {
                    navController.navigate(Routes.FRIEND_CHALLENGE) {
                        popUpTo(Routes.FRIEND_CHALLENGE) { inclusive = true }
                    }
                },
                onHome = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                }
            )
        }
    }
}
