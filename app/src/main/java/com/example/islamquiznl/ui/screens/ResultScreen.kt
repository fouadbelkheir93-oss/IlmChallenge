package com.example.islamquiznl.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.islamquiznl.R
import com.example.islamquiznl.ui.*
import com.example.islamquiznl.viewmodel.QuizViewModel

@Composable
fun ResultScreen(vm: QuizViewModel, onPlayAgain: () -> Unit, onHome: () -> Unit) {
    val state     by vm.state.collectAsState()
    val bestScore by vm.bestScore.collectAsState()
    val context   = LocalContext.current

    val won     = state.isWon
    val score   = state.score
    val correct = state.correctCount

    // ── Win geluid (alleen bij 15/15 in normale quiz) ──────────────────────────
    val winSoundPlayed = remember { mutableStateOf(false) }
    val mediaPlayer    = remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.value?.release()
            mediaPlayer.value = null
        }
    }

    LaunchedEffect(won, correct) {
        if (won && correct == 15 && !winSoundPlayed.value) {
            winSoundPlayed.value = true
            try {
                val mp = MediaPlayer.create(context, R.raw.win_sound)
                mp?.setOnCompletionListener { it.release() }
                mp?.start()
                mediaPlayer.value = mp
            } catch (e: Exception) {
                // Geluid niet beschikbaar, stilletjes overslaan
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55)))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (won) {
                Icon(Icons.Default.EmojiEvents, null, tint = GoldPrimary,
                    modifier = Modifier.size(80.dp))
                Spacer(Modifier.height(12.dp))
                Text("🌸 Allahoema Barik! 🌸", color = GoldPrimary, fontSize = 28.sp,
                    fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                Text("Je hebt de quiz uitgespeeld!", color = Color.White.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center)
            } else {
                Text("☽", fontSize = 64.sp, color = GoldPrimary.copy(alpha = 0.5f))
                Spacer(Modifier.height(8.dp))
                Text("Quiz afgelopen", color = Color.White, fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(32.dp))

            // Score card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f))
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ResultRow("Jouw score",     "$score punten", GoldPrimary)
                    Spacer(Modifier.height(12.dp))
                    ResultRow("Goed beantwoord", "$correct / 15", GreenIslamic)
                    Spacer(Modifier.height(12.dp))
                    ResultRow("Beste score",    "$bestScore punten", GoldLight)
                }
            }

            Spacer(Modifier.height(8.dp))
            Text(
                "Dit zijn punten, geen echt geld.",
                color = Color.White.copy(alpha = 0.35f),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = onPlayAgain,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = NavyDeep)
            ) {
                Text("Opnieuw spelen", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.5f))
            ) {
                Text("Terug naar home", fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
private fun ResultRow(label: String, value: String, valueColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = Color.White.copy(alpha = 0.7f),
            style = MaterialTheme.typography.bodyMedium)
        Text(value, color = valueColor, fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge)
    }
}
