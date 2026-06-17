package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.islamquiznl.ui.*
import com.example.islamquiznl.utils.ChallengeCodeUtils

@Composable
fun FriendChallengeScreen(
    onStartChallenge: (String) -> Unit,
    onBack: () -> Unit
) {
    var generatedCode by remember { mutableStateOf(ChallengeCodeUtils.generateCode()) }
    var inputCode     by remember { mutableStateOf("") }
    var inputError    by remember { mutableStateOf("") }
    val clipboard     = LocalClipboardManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55))))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, null, tint = GoldPrimary)
                }
                Spacer(Modifier.width(8.dp))
                Text(
                    "Daag je vriend uit",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Uitleg
                Text(
                    "Genereer een code of voer de code van je vriend in. Met dezelfde code krijgen jullie dezelfde vragen.",
                    color = Color.White.copy(alpha = 0.75f),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                // Sudden Death uitleg
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = GoldPrimary.copy(alpha = 0.1f))
                ) {
                    Text(
                        "⚡ Sudden Death: fout antwoord = klaar.\nWie het verst komt wint. Bij gelijkspel wint de snelste tijd.",
                        modifier = Modifier.padding(14.dp),
                        color = GoldPrimary,
                        style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                        textAlign = TextAlign.Center
                    )
                }

                // ── Sectie A: Code genereren ──────────────────────────────────
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.07f))
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            "Jouw code",
                            color = GoldPrimary,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )

                        // Grote code weergave
                        Text(
                            generatedCode,
                            color = Color.White,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 8.sp
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            OutlinedButton(
                                onClick = {
                                    clipboard.setText(AnnotatedString(generatedCode))
                                },
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldPrimary),
                                border = androidx.compose.foundation.BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.5f))
                            ) {
                                Icon(Icons.Default.ContentCopy, null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Kopieer")
                            }
                            OutlinedButton(
                                onClick = { generatedCode = ChallengeCodeUtils.generateCode() },
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.3f))
                            ) {
                                Icon(Icons.Default.Refresh, null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Nieuwe")
                            }
                        }

                        Button(
                            onClick = { onStartChallenge(generatedCode) },
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = NavyDeep)
                        ) {
                            Text("Start challenge ▶", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }

                // ── Sectie B: Code invoeren ───────────────────────────────────
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.07f))
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            "Code van vriend invoeren",
                            color = GoldPrimary,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )

                        OutlinedTextField(
                            value = inputCode,
                            onValueChange = {
                                inputCode  = it.uppercase().replace(" ", "").replace("-", "")
                                inputError = ""
                            },
                            label = { Text("Bijv. A7K3Q9", color = Color.White.copy(alpha = 0.5f)) },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Characters,
                                imeAction      = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(onDone = {
                                if (ChallengeCodeUtils.isValid(inputCode)) {
                                    onStartChallenge(inputCode)
                                } else {
                                    inputError = "Ongeldige code. Gebruik 6 tekens (bijv. A7K3Q9)."
                                }
                            }),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor   = GoldPrimary,
                                unfocusedBorderColor = Color.White.copy(alpha = 0.3f),
                                focusedTextColor     = Color.White,
                                unfocusedTextColor   = Color.White
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        if (inputError.isNotEmpty()) {
                            Text(inputError, color = ErrorRed,
                                style = MaterialTheme.typography.bodySmall)
                        }

                        Button(
                            onClick = {
                                val norm = ChallengeCodeUtils.normalize(inputCode)
                                if (ChallengeCodeUtils.isValid(norm)) {
                                    onStartChallenge(norm)
                                } else {
                                    inputError = "Ongeldige code. Gebruik 6 tekens (bijv. A7K3Q9)."
                                }
                            },
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GreenIslamic,
                                contentColor   = Color.White
                            )
                        ) {
                            Text("Start met deze code ▶", fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))
            }
        }
    }
}
