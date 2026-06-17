package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.islamquiznl.ui.GoldPrimary
import com.example.islamquiznl.ui.NavyDeep
import com.example.islamquiznl.ui.NavyMid

@Composable
fun HomeScreen(
    onStartQuiz: () -> Unit,
    onCategories: () -> Unit,
    onDailyQuestion: () -> Unit,
    onSettings: () -> Unit,
    onAbout: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55))))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("☪", fontSize = 60.sp, color = GoldPrimary)
            Spacer(Modifier.height(8.dp))
            Text(
                "IlmChallenge",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold, color = GoldPrimary, letterSpacing = 1.sp
                )
            )
            Text(
                "Test jouw islamitische kennis",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White.copy(alpha = 0.7f)),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(48.dp))
            Button(
                onClick = onStartQuiz,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = NavyDeep),
                elevation = ButtonDefaults.buttonElevation(8.dp)
            ) {
                Icon(Icons.Default.PlayArrow, null)
                Spacer(Modifier.width(8.dp))
                Text("Start quiz", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Spacer(Modifier.height(16.dp))
            HomeMenuButton(Icons.Default.Category,  "Categorieën",        onCategories)
            Spacer(Modifier.height(12.dp))
            HomeMenuButton(Icons.Default.People,    "Daag je vriend uit", onDailyQuestion)
            Spacer(Modifier.height(12.dp))
            HomeMenuButton(Icons.Default.Settings,  "Instellingen",       onSettings)
            Spacer(Modifier.height(12.dp))
            HomeMenuButton(Icons.Default.Info,      "Over de app",        onAbout)
        }
    }
}

@Composable
private fun HomeMenuButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(50.dp),
        shape    = RoundedCornerShape(25.dp),
        colors   = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
        border   = androidx.compose.foundation.BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.6f))
    ) {
        Icon(icon, null, tint = GoldPrimary, modifier = Modifier.size(20.dp))
        Spacer(Modifier.width(10.dp))
        Text(label, fontWeight = FontWeight.SemiBold)
    }
}
