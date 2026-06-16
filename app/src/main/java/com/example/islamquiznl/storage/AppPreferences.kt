package com.example.islamquiznl.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "islam_quiz_prefs")

class AppPreferences(private val context: Context) {

    companion object {
        val BEST_SCORE    = intPreferencesKey("best_score")
        val BEST_CORRECT  = intPreferencesKey("best_correct")
        val TIMER_ENABLED = booleanPreferencesKey("timer_enabled")
        val DARK_MODE     = booleanPreferencesKey("dark_mode")
    }

    val bestScore: Flow<Int>    = context.dataStore.data.map { it[BEST_SCORE]    ?: 0 }
    val bestCorrect: Flow<Int>  = context.dataStore.data.map { it[BEST_CORRECT]  ?: 0 }
    val timerEnabled: Flow<Boolean> = context.dataStore.data.map { it[TIMER_ENABLED] ?: false }
    val darkMode: Flow<Boolean>     = context.dataStore.data.map { it[DARK_MODE]     ?: true  }

    suspend fun saveBestScore(score: Int, correct: Int) {
        context.dataStore.edit { prefs ->
            val current = prefs[BEST_SCORE] ?: 0
            if (score > current) {
                prefs[BEST_SCORE]   = score
                prefs[BEST_CORRECT] = correct
            }
        }
    }

    suspend fun resetBestScore() {
        context.dataStore.edit { prefs ->
            prefs[BEST_SCORE]   = 0
            prefs[BEST_CORRECT] = 0
        }
    }

    suspend fun setTimerEnabled(enabled: Boolean) {
        context.dataStore.edit { it[TIMER_ENABLED] = enabled }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { it[DARK_MODE] = enabled }
    }
}
