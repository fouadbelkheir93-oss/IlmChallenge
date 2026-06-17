package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.islamquiznl.ui.*
import com.example.islamquiznl.viewmodel.ChallengeViewModel

@Composable
fun ChallengeResultScreen(
    vm: ChallengeViewModel,
    onPlayAgainSameCode: () -> Unit,
    onNewCode: () -> Unit,
    onHome: () -> Unit
) {
    val state by vm.state.collectAsState()

    val minutes = (state.elapsedMs / 1000) / 60
    val seconds = (state.elapsedMs / 1000) % 60
    val timeStr = if (minutes > 0) "${minutes}m ${seconds}s" else "${seconds}s"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55)))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("⚡", fontSize = 56.sp)

            Text(
                "Challenge klaar!",
                color = GoldPrimary,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            // Code weergave
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = GoldPrimary.copy(alpha = 0.15f)
            ) {
                Text(
                    state.code,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    color = GoldPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    letterSpacing = 4.sp
                )
            }

            // Resultaat kaart
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f))
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    ResultRowChallenge("Goede antwoorden", "${state.correctCount}", GoldPrimary)
                    Spacer(Modifier.height(10.dp))
                    ResultRowChallenge("Bereikte vraag",   "${state.questionNumber}", Color.White)
                    Spacer(Modifier.height(10.dp))
                    ResultRowChallenge("Totale tijd",      timeStr, GreenIslamic)
                }
            }

            // Uitleg vergelijking
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = GoldPrimary.copy(alpha = 0.08f))
            ) {
                Text(
                    "Vergelijk dit met je vriend.\nHoogste aantal goede antwoorden wint.\nBij gelijkspel wint de snelste tijd.",
                    modifier = Modifier.padding(16.dp),
                    color = GoldPrimary.copy(alpha = 0.9f),
                    style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(4.dp))

            // Knoppen
            Button(
                onClick = onPlayAgainSameCode,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = NavyDeep)
            ) {
                Text("Opnieuw met dezelfde code", fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = onNewCode,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.5f))
            ) {
                Text("Nieuwe code", fontWeight = FontWeight.SemiBold)
            }

            OutlinedButton(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White.copy(alpha = 0.6f)),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.2f))
            ) {
                Text("Terug naar menu")
            }
        }
    }
}

@Composable
private fun ResultRowChallenge(label: String, value: String, valueColor: Color) {
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
