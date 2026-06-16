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
import com.example.islamquiznl.viewmodel.SCORE_LADDER
import com.example.islamquiznl.viewmodel.QuizViewModel

@Composable
fun QuizScreen(vm: QuizViewModel, onGameEnd: () -> Unit, onBack: () -> Unit) {
    val state by vm.state.collectAsState()
    val timerEnabled by vm.prefs.timerEnabled.collectAsState(initial = false)

    LaunchedEffect(state.isGameOver, state.isWon) {
        if (state.isGameOver || state.isWon) {
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
            // Top bar
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, null, tint = GoldPrimary)
                }
                Spacer(Modifier.weight(1f))
                Text(
                    "Vraag ${state.questionNumber} van 15",
                    color = Color.White.copy(alpha = 0.8f),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.weight(1f))
                Text(
                    "${state.score} pt",
                    color = GoldPrimary,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(4.dp))

            // Progress bar
            LinearProgressIndicator(
                progress = { state.questionNumber / 15f },
                modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                color = GoldPrimary,
                trackColor = Color.White.copy(alpha = 0.15f)
            )

            Spacer(Modifier.height(8.dp))

            // Timer
            if (timerEnabled) {
                val timerColor = when {
                    state.timerSeconds <= 5 -> Color.Red
                    state.timerSeconds <= 10 -> Color(0xFFFFA500)
                    else -> GoldPrimary
                }
                Text(
                    "⏱ ${state.timerSeconds}s",
                    color = timerColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(4.dp))
            }

            // Difficulty badge
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
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = diffColor.copy(alpha = 0.25f)
                ) {
                    Text(
                        diffLabel,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                        color = diffColor,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = GoldPrimary.copy(alpha = 0.15f)
                ) {
                    Text(
                        q.sourceCategory,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                        color = GoldPrimary.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            // Question card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape    = RoundedCornerShape(20.dp),
                colors   = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f)),
                elevation = CardDefaults.cardElevation(0.dp)
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

            // Answer options
            q.answers.forEachIndexed { idx, answer ->
                if (idx in state.hiddenAnswers) return@forEachIndexed

                val bgColor by animateColorAsState(
                    targetValue = when {
                        !state.isAnswered            -> Color.White.copy(alpha = 0.08f)
                        idx == q.correctAnswerIndex  -> SuccessGreen.copy(alpha = 0.85f)
                        idx == state.selectedAnswer  -> ErrorRed.copy(alpha = 0.85f)
                        else                         -> Color.White.copy(alpha = 0.04f)
                    },
                    animationSpec = tween(400), label = "bg"
                )
                val borderColor by animateColorAsState(
                    targetValue = when {
                        !state.isAnswered            -> GoldPrimary.copy(alpha = 0.3f)
                        idx == q.correctAnswerIndex  -> SuccessGreen
                        idx == state.selectedAnswer  -> ErrorRed
                        else                         -> Color.Transparent
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

            // Hint banners
            if (state.showHint) {
                Spacer(Modifier.height(12.dp))
                InfoBanner("💡 Hint", state.hintText, GoldPrimary) { vm.dismissHint() }
            }
            if (state.showImam) {
                Spacer(Modifier.height(8.dp))
                InfoBanner("🕌 Vraag de imam", state.imamText, GreenIslamic) { vm.dismissImam() }
            }

            // Explanation
            if (state.showExplanation) {
                Spacer(Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (state.selectedAnswer == q.correctAnswerIndex || state.isWon)
                            SuccessGreen.copy(alpha = 0.2f) else ErrorRed.copy(alpha = 0.15f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            if (state.selectedAnswer == q.correctAnswerIndex || state.isWon) "✅ Goed!" else "❌ Helaas!",
                            color = Color.White, fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(q.explanation, color = Color.White.copy(alpha = 0.9f),
                            style = MaterialTheme.typography.bodySmall)
                    }
                }

                if (!state.isGameOver && !state.isWon) {
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = { vm.nextQuestion() },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = NavyDeep)
                    ) {
                        Text("Volgende vraag →", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Lifelines
            if (!state.isAnswered) {
                LifelineRow(state, vm)
            }

            Spacer(Modifier.height(16.dp))

            // Score ladder (compact)
            ScoreLadder(currentIndex = state.currentIndex)
        }
    }
}

@Composable
private fun InfoBanner(title: String, text: String, color: Color, onDismiss: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.18f))
    ) {
        Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.Top) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = color, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium)
                Text(text, color = Color.White.copy(alpha = 0.9f),
                    style = MaterialTheme.typography.bodySmall)
            }
            TextButton(onClick = onDismiss) { Text("✕", color = color) }
        }
    }
}

@Composable
private fun LifelineRow(state: com.example.islamquiznl.viewmodel.QuizState, vm: QuizViewModel) {
    Column {
        Text("Hulplijnen", color = GoldPrimary.copy(alpha = 0.8f),
            style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(6.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            LifelineButton("50/50", !state.fiftyFiftyUsed) { vm.useFiftyFifty() }
            LifelineButton("💡 Hint", !state.hintUsed) { vm.useHint() }
            LifelineButton("🕌 Imam", !state.imamUsed) { vm.useImam() }
            LifelineButton("⏭ Skip", !state.skipUsed) { vm.useSkip() }
        }
        Spacer(Modifier.height(4.dp))
        Text(
            "* \"Vraag de imam\" is een extra hint, geen echte imam",
            color = Color.White.copy(alpha = 0.35f),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
private fun RowScope.LifelineButton(label: String, enabled: Boolean, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.weight(1f).height(38.dp),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 4.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = if (enabled) GoldPrimary else Color.Gray),
        border = androidx.compose.foundation.BorderStroke(
            1.dp, if (enabled) GoldPrimary.copy(alpha = 0.6f) else Color.Gray.copy(alpha = 0.3f)
        )
    ) {
        Text(label, fontSize = 10.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
    }
}

@Composable
private fun ScoreLadder(currentIndex: Int) {
    val labels = listOf("100","200","300","500","1K","2K","4K","8K","16K","32K","64K","125K","250K","500K","1M")
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.05f))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("Scoreladder", color = GoldPrimary, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelMedium)
            Spacer(Modifier.height(8.dp))
            labels.forEachIndexed { idx, pts ->
                val stepIdx = 14 - idx
                val isActive  = stepIdx == currentIndex
                val isPassed  = stepIdx < currentIndex
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            when {
                                isActive -> GoldPrimary.copy(alpha = 0.25f)
                                isPassed -> GreenIslamic.copy(alpha = 0.15f)
                                else     -> Color.Transparent
                            }
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Vraag ${15 - idx}",
                        color = if (isActive) GoldPrimary else Color.White.copy(alpha = 0.5f),
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text(
                        "$pts punten",
                        color = when {
                            isActive -> GoldPrimary
                            isPassed -> GreenIslamic
                            else     -> Color.White.copy(alpha = 0.4f)
                        },
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal)
                    )
                }
            }
        }
    }
}
