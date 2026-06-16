package com.example.islamquiznl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.islamquiznl.navigation.AppNavigation
import com.example.islamquiznl.ui.IslamQuizTheme
import com.example.islamquiznl.viewmodel.QuizViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val vm: QuizViewModel = viewModel()
            val darkMode by vm.prefs.darkMode.collectAsState(initial = true)
            IslamQuizTheme(darkTheme = darkMode) {
                AppNavigation(vm = vm)
            }
        }
    }
}
