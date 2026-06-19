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
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.window.Dialog
import com.example.islamquiznl.ui.*
import com.example.islamquiznl.utils.TimerSoundPlayer
import com.example.islamquiznl.viewmodel.SCORE_LADDER
import com.example.islamquiznl.viewmodel.QuizViewModel
import com.example.islamquiznl.viewmodel.formatScore

@Composable
fun QuizScreen(vm: QuizViewModel, onGameEnd: () -> Unit, onBack: () -> Unit) {
    val state        by vm.state.collectAsState()
    val timerEnabled by vm.prefs.timerEnabled.collectAsState(initial = false)
    var showLadder   by remember { mutableStateOf(false) }

    // ── Timer geluid ───────────────────────────────────────────────────────────
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

    // Speel tik af bij laatste 10 seconden
    LaunchedEffect(state.timerSeconds, state.isAnswered, state.currentIndex, timerEnabled) {
        if (!state.isAnswered && timerEnabled) {
            when {
                state.timerSeconds in 1..10 ->
                    timerSoundPlayer.playTick(
                        remainingSeconds = state.timerSeconds,
                        soundEnabled     = true
                    )
                state.timerSeconds == 0 ->
                    timerSoundPlayer.playTimeUp(soundEnabled = true)
            }
        }
    }

    // Fout-antwoord geluid
    LaunchedEffect(state.isAnswered, state.isGameOver, state.timerSeconds, state.currentIndex) {
        val isWrongAnswer = state.isAnswered && state.isGameOver
        val isTimeUp      = state.timerSeconds == 0 && !state.isAnswered
        if (!wrongSoundPlayed.value && (isWrongAnswer || isTimeUp) && timerEnabled) {
            timerSoundPlayer.playWrongAnswer(soundEnabled = true)
            wrongSoundPlayed.value = true
        }
    }

    LaunchedEffect(state.isWon) {
        if (state.isWon) {
            kotlinx.coroutines.delay(1500)
            onGameEnd()
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
            // ── Top bar ────────────────────────────────────────────────────────
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, null, tint = GoldPrimary)
                }
                Spacer(Modifier.weight(1f))
                Text(
                    "Vraag ${state.questionNumber} / 15",
                    color = Color.White.copy(alpha = 0.8f),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.weight(1f))
                // Score + Scoreladder knop
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        "${formatScore(state.score)} pt",
                        color = GoldPrimary,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "→ ${formatScore(state.currentLevelPoints)} pt",
                        color = GoldPrimary.copy(alpha = 0.6f),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Spacer(Modifier.width(8.dp))
                IconButton(onClick = { showLadder = true }) {
                    Icon(Icons.Default.Star, null, tint = GoldPrimary, modifier = Modifier.size(22.dp))
                }
            }

            // ── Progress bar ───────────────────────────────────────────────────
            LinearProgressIndicator(
                progress = { state.questionNumber / 15f },
                modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                color = GoldPrimary,
                trackColor = Color.White.copy(alpha = 0.15f)
            )

            Spacer(Modifier.height(8.dp))

            // ── Timer ──────────────────────────────────────────────────────────
            if (timerEnabled && !state.isAnswered) {
                val timerColor = when {
                    state.timerSeconds <= 10 -> Color.Red
                    state.timerSeconds <= 20 -> Color(0xFFFFA500)
                    else -> GoldPrimary
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("⏱", fontSize = 14.sp)
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "${state.timerSeconds}s",
                        color = timerColor,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(Modifier.height(4.dp))
            }

            // ── Difficulty + Category badges ───────────────────────────────────
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(shape = RoundedCornerShape(12.dp), color = diffColor.copy(alpha = 0.22f)) {
                    Text(
                        diffLabel,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                        color = diffColor,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Surface(shape = RoundedCornerShape(12.dp), color = GoldPrimary.copy(alpha = 0.13f)) {
                    Text(
                        q.sourceCategory,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                        color = GoldPrimary.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            // ── Question card ──────────────────────────────────────────────────
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f))
            ) {
                Text(
                    q.question,
                    modifier = Modifier.padding(20.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold, lineHeight = 26.sp
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(16.dp))

            // ── Answer options ─────────────────────────────────────────────────
            q.answers.forEachIndexed { idx, answer ->
                if (idx in state.hiddenAnswers) return@forEachIndexed

                val bgColor by animateColorAsState(
                    targetValue = when {
                        !state.isAnswered                -> Color.White.copy(alpha = 0.08f)
                        idx == q.correctAnswerIndex      -> SuccessGreen.copy(alpha = 0.85f)
                        idx == state.selectedAnswer      -> ErrorRed.copy(alpha = 0.85f)
                        else                             -> Color.White.copy(alpha = 0.04f)
                    },
                    animationSpec = tween(400), label = "bg"
                )
                val borderColor by animateColorAsState(
                    targetValue = when {
                        !state.isAnswered                -> GoldPrimary.copy(alpha = 0.3f)
                        idx == q.correctAnswerIndex      -> SuccessGreen
                        idx == state.selectedAnswer      -> ErrorRed
                        else                             -> Color.Transparent
                    },
                    animationSpec = tween(400), label = "border"
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(bgColor)
                        .border(1.dp, borderColor, RoundedCornerShape(14.dp))
                        .clickable(enabled = !state.isAnswered) { vm.selectAnswer(idx) }
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = GoldPrimary.copy(alpha = 0.2f),
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Text(
                                    listOf("A", "B", "C", "D")[idx],
                                    color = GoldPrimary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        Spacer(Modifier.width(12.dp))
                        Text(answer, color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            // ── Hint banner ────────────────────────────────────────────────────
            if (state.showHint) {
                Spacer(Modifier.height(12.dp))
                HintBanner(
                    title    = "💡 Hint",
                    text     = state.hintText,
                    color    = GoldPrimary,
                    onClose  = { vm.dismissHint() }
                )
            }

            // ── Imam banner ────────────────────────────────────────────────────
            if (state.showImam) {
                Spacer(Modifier.height(8.dp))
                HintBanner(
                    title    = "🕌 Vraag de imam",
                    text     = state.imamText,
                    color    = GreenIslamic,
                    onClose  = { vm.dismissImam() }
                )
            }

            // ── Explanation after answer ───────────────────────────────────────
            if (state.showExplanation) {
                Spacer(Modifier.height(16.dp))

                val isCorrect = state.selectedAnswer == q.correctAnswerIndex
                val cardColor = if (isCorrect) SuccessGreen.copy(alpha = 0.2f)
                                else ErrorRed.copy(alpha = 0.15f)

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        // Uitkomst label
                        Text(
                            if (isCorrect) "✅ Juist!" else "❌ Fout!",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        // Toon correct antwoord bij fout
                        if (!isCorrect) {
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Het juiste antwoord: ${q.answers[q.correctAnswerIndex]}",
                                color = SuccessGreen,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Spacer(Modifier.height(8.dp))
                        Divider(color = Color.White.copy(alpha = 0.15f))
                        Spacer(Modifier.height(8.dp))

                        // Uitleg — niet afgekapt
                        Text(
                            q.explanation,
                            color = Color.White.copy(alpha = 0.92f),
                            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp)
                        )
                    }
                }

                // Knoppen na antwoord
                Spacer(Modifier.height(16.dp))
                when {
                    state.isGameOver -> {
                        // Fout antwoord: toon "Bekijk resultaat"
                        Button(
                            onClick = onGameEnd,
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
                    !state.isWon -> {
                        // Goed antwoord, nog niet klaar: volgende vraag
                        Button(
                            onClick = { vm.nextQuestion() },
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GoldPrimary,
                                contentColor   = NavyDeep
                            )
                        ) {
                            Text("Volgende vraag →", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                    // isWon: automatisch navigeren via LaunchedEffect
                }
            }

            Spacer(Modifier.height(16.dp))

            // ── Lifelines ──────────────────────────────────────────────────────
            if (!state.isAnswered) {
                LifelineRow(state = state, vm = vm)
            }

            Spacer(Modifier.height(24.dp))
        }
    }

    // ── Scoreladder Dialog ─────────────────────────────────────────────────────
    if (showLadder) {
        ScoreLadderDialog(
            currentIndex = state.currentIndex,
            onDismiss    = { showLadder = false }
        )
    }
}

// ── Hint/Imam banner ───────────────────────────────────────────────────────────
@Composable
private fun HintBanner(title: String, text: String, color: Color, onClose: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.16f)),
        border = CardDefaults.outlinedCardBorder().copy(width = 0.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    title,
                    color = color,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelLarge
                )
                TextButton(
                    onClick = onClose,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("✕", color = color.copy(alpha = 0.7f))
                }
            }
            Spacer(Modifier.height(6.dp))
            Text(
                text,
                color = Color.White.copy(alpha = 0.92f),
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp)
            )
        }
    }
}

// ── Lifeline row ───────────────────────────────────────────────────────────────
@Composable
private fun LifelineRow(
    state: com.example.islamquiznl.viewmodel.QuizState,
    vm: QuizViewModel
) {
    Column {
        Text(
            "Hulplijnen",
            color = GoldPrimary.copy(alpha = 0.8f),
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(Modifier.height(6.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            LifelineBtn("50/50",     !state.fiftyFiftyUsed) { vm.useFiftyFifty() }
            LifelineBtn("💡 Hint",   !state.hintUsed)       { vm.useHint() }
            LifelineBtn("🕌 Imam",   !state.imamUsed)       { vm.useImam() }
            LifelineBtn("⏭ Skip",   !state.skipUsed)       { vm.useSkip() }
        }
        Spacer(Modifier.height(4.dp))
        Text(
            "* \"Vraag de imam\" is een extra hint",
            color = Color.White.copy(alpha = 0.3f),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
private fun RowScope.LifelineBtn(label: String, enabled: Boolean, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.weight(1f).height(38.dp),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor         = if (enabled) GoldPrimary else Color.Gray,
            disabledContentColor = Color.Gray.copy(alpha = 0.4f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (enabled) GoldPrimary.copy(alpha = 0.6f) else Color.Gray.copy(alpha = 0.2f)
        )
    ) {
        Text(label, fontSize = 10.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
    }
}

// ── Scoreladder Dialog (miljoenenquiz stijl) ───────────────────────────────────
@Composable
private fun ScoreLadderDialog(currentIndex: Int, onDismiss: () -> Unit) {
    // Ladder: vraag 15 bovenaan, vraag 1 onderaan — zoals echte miljoenenquiz
    val steps = listOf(
        15 to 1_000_000,
        14 to 500_000,
        13 to 250_000,
        12 to 125_000,
        11 to 64_000,
        10 to 32_000,
        9  to 16_000,
        8  to 8_000,
        7  to 4_000,
        6  to 2_000,
        5  to 1_000,
        4  to 500,
        3  to 300,
        2  to 200,
        1  to 100
    )

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = NavyMid)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "☪ Scoreladder",
                        color = GoldPrimary,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    TextButton(onClick = onDismiss) {
                        Text("✕", color = GoldPrimary.copy(alpha = 0.7f))
                    }
                }

                Spacer(Modifier.height(12.dp))

                steps.forEach { (questionNum, points) ->
                    val stepIndex = questionNum - 1   // 0-based
                    val isCurrent = stepIndex == currentIndex
                    val isPassed  = stepIndex < currentIndex

                    // Kleur per status
                    val rowBg = when {
                        isCurrent -> GoldPrimary.copy(alpha = 0.22f)
                        isPassed  -> GreenIslamic.copy(alpha = 0.13f)
                        else      -> Color.Transparent
                    }
                    val labelColor = when {
                        isCurrent -> GoldPrimary
                        isPassed  -> GreenIslamic
                        else      -> Color.White.copy(alpha = 0.35f)
                    }
                    val pointsColor = when {
                        isCurrent -> GoldPrimary
                        isPassed  -> GreenIslamic.copy(alpha = 0.9f)
                        else      -> Color.White.copy(alpha = 0.3f)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(rowBg)
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // Icoon per status
                            Text(
                                when {
                                    isCurrent -> "▶"
                                    isPassed  -> "✓"
                                    else      -> "  "
                                },
                                color = labelColor,
                                fontSize = 11.sp,
                                modifier = Modifier.width(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                "Vraag $questionNum",
                                color = labelColor,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal
                                )
                            )
                        }
                        Text(
                            "${formatScore(points)} punten",
                            color = pointsColor,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    }
                }

                Spacer(Modifier.height(8.dp))
                Text(
                    "Geen echt geld — alleen punten",
                    color = Color.White.copy(alpha = 0.25f),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
