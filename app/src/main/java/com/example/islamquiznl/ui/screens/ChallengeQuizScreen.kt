package com.example.islamquiznl.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.islamquiznl.ui.*
import com.example.islamquiznl.utils.TimerSoundPlayer
import com.example.islamquiznl.viewmodel.ChallengeViewModel

@Composable
fun ChallengeQuizScreen(
    vm: ChallengeViewModel,
    onFinished: () -> Unit,
    onBack: () -> Unit
) {
    val state by vm.state.collectAsState()

    // ── Timer geluid (altijd aan in challenge) ─────────────────────────────────
    val timerSoundPlayer = remember { TimerSoundPlayer() }
    val wrongSoundPlayed = remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        onDispose { timerSoundPlayer.release() }
    }

    // Reset geluid bij nieuwe vraag
    LaunchedEffect(state.currentIndex) {
        timerSoundPlayer.reset()
        wrongSoundPlayed.value = false
    }

    // Tik bij laatste 10 seconden
    LaunchedEffect(state.timerSeconds, state.isAnswered, state.currentIndex) {
        if (!state.isAnswered) {
            when {
                state.timerSeconds in 1..10 ->
                    timerSoundPlayer.playTick(state.timerSeconds, soundEnabled = true)
                state.timerSeconds == 0 ->
                    timerSoundPlayer.playTimeUp(soundEnabled = true)
            }
        }
    }

    // Fout-antwoord geluid
    LaunchedEffect(state.isAnswered, state.isCorrect, state.timerSeconds, state.currentIndex) {
        val isWrongAnswer = state.isAnswered && !state.isCorrect
        val isTimeUp      = state.timerSeconds == 0 && !state.isAnswered
        if (!wrongSoundPlayed.value && (isWrongAnswer || isTimeUp)) {
            timerSoundPlayer.playWrongAnswer(soundEnabled = true)
            wrongSoundPlayed.value = true
        }
    }

    LaunchedEffect(state.isFinished, state.isCorrect) {
        // Alleen automatisch doorgaan bij het voltooien van alle vragen (gewonnen)
        if (state.isFinished && state.isCorrect) {
            kotlinx.coroutines.delay(1500)
            onFinished()
        }
    }

    val q = state.currentQuestion ?: return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55))))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Top bar
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, null, tint = GoldPrimary)
                }
                Spacer(Modifier.weight(1f))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("⚡ Challenge", color = GoldPrimary, fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium)
                    Text(state.code, color = GoldPrimary.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.labelSmall, letterSpacing = 2.sp)
                }
                Spacer(Modifier.weight(1f))
                Text("${state.correctCount} ✓", color = GreenIslamic,
                    fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(Modifier.height(8.dp))

            // Progress
            LinearProgressIndicator(
                progress = { state.currentIndex.toFloat() / state.totalQuestions.coerceAtLeast(1) },
                modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                color = GoldPrimary, trackColor = Color.White.copy(alpha = 0.15f)
            )

            Spacer(Modifier.height(12.dp))

            // Timer (altijd aan in challenge)
            if (!state.isAnswered) {
                val timerColor = when {
                    state.timerSeconds <= 5  -> Color.Red
                    state.timerSeconds <= 10 -> Color(0xFFFFA500)
                    else -> GoldPrimary
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("⏱", fontSize = 14.sp)
                    Spacer(Modifier.width(4.dp))
                    Text("${state.timerSeconds}s", color = timerColor,
                        fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge)
                }
                Spacer(Modifier.height(8.dp))
            }

            // Badges
            val diffColor = when (q.difficulty.name) {
                "EASY"   -> GreenIslamic
                "MEDIUM" -> Color(0xFFF59E0B)
                else     -> Color(0xFFDC2626)
            }
            val diffLabel = when (q.difficulty.name) {
                "EASY"   -> "Makkelijk"
                "MEDIUM" -> "Gemiddeld"
                else     -> "Moeilijk"
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Surface(shape = RoundedCornerShape(12.dp), color = diffColor.copy(alpha = 0.22f)) {
                    Text(diffLabel,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                        color = diffColor,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold))
                }
                Text("Vraag ${state.questionNumber}", color = Color.White.copy(alpha = 0.6f),
                    style = MaterialTheme.typography.labelMedium)
            }

            Spacer(Modifier.height(16.dp))

            // Vraag
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f))) {
                Text(q.question, modifier = Modifier.padding(20.dp), color = Color.White,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold, lineHeight = 26.sp),
                    textAlign = TextAlign.Center)
            }

            Spacer(Modifier.height(16.dp))

            // Antwoorden
            q.answers.forEachIndexed { idx, answer ->
                val bgColor by animateColorAsState(
                    targetValue = when {
                        !state.isAnswered            -> Color.White.copy(alpha = 0.08f)
                        idx == q.correctAnswerIndex  -> SuccessGreen.copy(alpha = 0.85f)
                        idx == state.selectedAnswer  -> ErrorRed.copy(alpha = 0.85f)
                        else                         -> Color.White.copy(alpha = 0.04f)
                    }, animationSpec = tween(400), label = "bg"
                )
                val borderColor by animateColorAsState(
                    targetValue = when {
                        !state.isAnswered            -> GoldPrimary.copy(alpha = 0.3f)
                        idx == q.correctAnswerIndex  -> SuccessGreen
                        idx == state.selectedAnswer  -> ErrorRed
                        else                         -> Color.Transparent
                    }, animationSpec = tween(400), label = "border"
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth().padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(bgColor)
                        .border(1.dp, borderColor, RoundedCornerShape(14.dp))
                        .clickable(enabled = !state.isAnswered) { vm.selectAnswer(idx) }
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(shape = RoundedCornerShape(8.dp), color = GoldPrimary.copy(alpha = 0.2f),
                            modifier = Modifier.size(32.dp)) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Text(listOf("A","B","C","D")[idx], color = GoldPrimary,
                                    fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            }
                        }
                        Spacer(Modifier.width(12.dp))
                        Text(answer, color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            // Feedback na antwoord
            if (state.isAnswered) {
                Spacer(Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (state.isCorrect) SuccessGreen.copy(alpha = 0.2f)
                                         else ErrorRed.copy(alpha = 0.15f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            if (state.isCorrect) "✅ Juist! Ga door..." else "❌ Fout! Challenge gestopt.",
                            color = Color.White, fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        if (!state.isCorrect) {
                            Spacer(Modifier.height(6.dp))
                            Text("Juist antwoord: ${q.answers[q.correctAnswerIndex]}",
                                color = SuccessGreen, fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.bodyMedium)
                            Spacer(Modifier.height(6.dp))
                            Divider(color = Color.White.copy(alpha = 0.1f))
                            Spacer(Modifier.height(6.dp))
                            Text(q.explanation, color = Color.White.copy(alpha = 0.85f),
                                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp))
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))
                when {
                    !state.isCorrect && state.isAnswered -> {
                        // Fout antwoord: toon "Bekijk resultaat"
                        Button(
                            onClick = onFinished,
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = ErrorRed,
                                contentColor   = Color.White
                            )
                        ) {
                            Text("Bekijk resultaat →", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                    state.isCorrect && !state.isFinished -> {
                        // Goed antwoord, nog vragen over
                        Button(
                            onClick = { vm.nextQuestion() },
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = NavyDeep)
                        ) {
                            Text("Volgende vraag →", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
