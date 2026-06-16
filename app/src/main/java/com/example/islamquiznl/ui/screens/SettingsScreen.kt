package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.islamquiznl.ui.*
import com.example.islamquiznl.viewmodel.QuizViewModel

@Composable
fun SettingsScreen(vm: QuizViewModel, onBack: () -> Unit) {
    val timerEnabled by vm.prefs.timerEnabled.collectAsState(initial = false)
    val darkMode     by vm.prefs.darkMode.collectAsState(initial = true)
    var showResetDialog by remember { mutableStateOf(false) }

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
                Text("Instellingen", color = Color.White, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge)
            }

            Spacer(Modifier.height(24.dp))

            SettingsCard {
                SettingSwitch(
                    label    = "Timer (30 seconden per vraag)",
                    subLabel = "Bij 0 seconden eindigt de quiz",
                    checked  = timerEnabled,
                    onCheck  = { vm.setTimerEnabled(it) }
                )
                Divider(color = Color.White.copy(alpha = 0.1f), thickness = 1.dp)
                SettingSwitch(
                    label    = "Donkere modus",
                    subLabel = "Donkerblauwe achtergrond (standaard)",
                    checked  = darkMode,
                    onCheck  = { vm.setDarkMode(it) }
                )
            }

            Spacer(Modifier.height(24.dp))

            SettingsCard {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Beste score", color = Color.White, fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge)
                    Text("Verwijdert je huidige beste score definitief",
                        color = Color.White.copy(alpha = 0.5f),
                        style = MaterialTheme.typography.bodySmall)
                    Spacer(Modifier.height(12.dp))
                    OutlinedButton(
                        onClick = { showResetDialog = true },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = ErrorRed),
                        border = androidx.compose.foundation.BorderStroke(1.dp, ErrorRed.copy(alpha = 0.5f))
                    ) {
                        Text("Reset beste score")
                    }
                }
            }
        }
    }

    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            containerColor   = NavyMid,
            title = { Text("Beste score resetten?", color = Color.White) },
            text  = { Text("Dit kan niet ongedaan worden gemaakt.", color = Color.White.copy(alpha = 0.7f)) },
            confirmButton = {
                TextButton(onClick = { vm.resetBestScore(); showResetDialog = false }) {
                    Text("Resetten", color = ErrorRed)
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }) {
                    Text("Annuleren", color = GoldPrimary)
                }
            }
        )
    }
}

@Composable
private fun SettingsCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f)),
        content = { Column(content = content) }
    )
}

@Composable
private fun SettingSwitch(label: String, subLabel: String, checked: Boolean, onCheck: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f).padding(end = 12.dp)) {
            Text(label, color = Color.White, style = MaterialTheme.typography.bodyMedium)
            Text(subLabel, color = Color.White.copy(alpha = 0.5f),
                style = MaterialTheme.typography.bodySmall)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheck,
            colors = SwitchDefaults.colors(checkedThumbColor = NavyDeep, checkedTrackColor = GoldPrimary)
        )
    }
}
