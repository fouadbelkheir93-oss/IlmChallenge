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
import com.example.islamquiznl.ui.screens.AboutScreen
import com.example.islamquiznl.ui.screens.CategoryScreen
import com.example.islamquiznl.ui.screens.DailyQuestionScreen
import com.example.islamquiznl.ui.screens.HomeScreen
import com.example.islamquiznl.ui.screens.QuizScreen
import com.example.islamquiznl.ui.screens.ResultScreen
import com.example.islamquiznl.ui.screens.SettingsScreen
import com.example.islamquiznl.viewmodel.QuizViewModel

@Composable
fun AppNavigation(vm: QuizViewModel = viewModel()) {
    val navController = rememberNavController()
    val state by vm.state.collectAsState()

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onStartQuiz = {
                    vm.startQuiz()
                    navController.navigate(Routes.QUIZ)
                },
                onCategories = { navController.navigate(Routes.CATEGORIES) },
                onDailyQuestion = {
                    vm.loadDailyQuestion()
                    navController.navigate(Routes.DAILY_QUESTION)
                },
                onSettings = { navController.navigate(Routes.SETTINGS) },
                onAbout = { navController.navigate(Routes.ABOUT) }
            )
        }

        composable(Routes.QUIZ) {
            QuizScreen(
                vm = vm,
                onGameEnd = {
                    navController.navigate(Routes.RESULT) {
                        popUpTo(Routes.QUIZ) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.QUIZ_CATEGORY,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category")
            val category = categoryName?.let { runCatching { QuizCategory.valueOf(it) }.getOrNull() }

            LaunchedEffect(categoryName) {
                vm.startQuiz(category)
            }

            // Wait for the category round to be created before drawing QuizScreen. This prevents
            // resetting the quiz on every recomposition and avoids a blank screen during setup.
            if (state.questions.isNotEmpty()) {
                QuizScreen(
                    vm = vm,
                    onGameEnd = {
                        navController.navigate(Routes.RESULT) {
                            popUpTo(Routes.QUIZ_CATEGORY) { inclusive = true }
                        }
                    },
                    onBack = { navController.popBackStack() }
                )
            }
        }

        composable(Routes.RESULT) {
            ResultScreen(
                vm = vm,
                onPlayAgain = {
                    vm.startQuiz()
                    navController.navigate(Routes.QUIZ) {
                        popUpTo(Routes.HOME)
                    }
                },
                onHome = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.CATEGORIES) {
            CategoryScreen(
                onCategorySelected = { category -> navController.navigate("quiz/${category.name}") },
                onBack = { navController.popBackStack() }
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
    }
}
