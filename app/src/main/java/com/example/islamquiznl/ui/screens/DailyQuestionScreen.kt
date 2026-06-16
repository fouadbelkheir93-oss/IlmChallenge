package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.islamquiznl.viewmodel.QuizViewModel

@Composable
fun DailyQuestionScreen(vm: QuizViewModel, onBack: () -> Unit) {
    val q        by vm.dailyQuestion.collectAsState()
    val answered by vm.dailyAnswered.collectAsState()
    val selected by vm.dailySelected.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55))))
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, null, tint = GoldPrimary)
                }
                Spacer(Modifier.width(8.dp))
                Text("Dagelijkse vraag", color = Color.White, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge)
            }

            Spacer(Modifier.height(24.dp))

            if (q == null) {
                CircularProgressIndicator(color = GoldPrimary, modifier = Modifier.align(Alignment.CenterHorizontally))
                return@Column
            }

            val question = q!!

            // Category badge
            Surface(shape = RoundedCornerShape(12.dp), color = GoldPrimary.copy(alpha = 0.15f)) {
                Text(
                    question.sourceCategory,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    color = GoldPrimary,
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Spacer(Modifier.height(16.dp))

            // Question
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f))
            ) {
                Text(
                    question.question,
                    modifier = Modifier.padding(20.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(16.dp))

            // Answers
            question.answers.forEachIndexed { idx, answer ->
                val bgColor = when {
                    !answered -> Color.White.copy(alpha = 0.07f)
                    idx == question.correctAnswerIndex -> SuccessGreen.copy(alpha = 0.8f)
                    idx == selected -> ErrorRed.copy(alpha = 0.8f)
                    else -> Color.White.copy(alpha = 0.03f)
                }
                val borderColor = when {
                    !answered -> GoldPrimary.copy(alpha = 0.3f)
                    idx == question.correctAnswerIndex -> SuccessGreen
                    idx == selected -> ErrorRed
                    else -> Color.Transparent
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(bgColor)
                        .border(1.dp, borderColor, RoundedCornerShape(14.dp))
                        .clickable(enabled = !answered) { vm.answerDaily(idx) }
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(shape = RoundedCornerShape(8.dp), color = GoldPrimary.copy(alpha = 0.2f),
                            modifier = Modifier.size(30.dp)) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Text(listOf("A","B","C","D")[idx], color = GoldPrimary,
                                    fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            }
                        }
                        Spacer(Modifier.width(12.dp))
                        Text(answer, color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            // Explanation
            if (answered) {
                Spacer(Modifier.height(16.dp))
                val correct = selected == question.correctAnswerIndex
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (correct) SuccessGreen.copy(alpha = 0.2f)
                                         else ErrorRed.copy(alpha = 0.15f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(if (correct) "✅ Juist!" else "❌ Helaas!", color = Color.White,
                            fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(6.dp))
                        Text(question.explanation, color = Color.White.copy(alpha = 0.9f),
                            style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
