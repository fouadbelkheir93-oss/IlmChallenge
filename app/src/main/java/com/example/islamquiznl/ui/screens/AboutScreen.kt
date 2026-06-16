package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.islamquiznl.ui.*

@Composable
fun AboutScreen(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyDeep, NavyMid, Color(0xFF0F2E55))))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, null, tint = GoldPrimary)
                }
                Spacer(Modifier.width(8.dp))
                Text("Over de app", color = Color.White, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("☪", fontSize = 48.sp, color = GoldPrimary,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(
                    "Islam Quiz NL",
                    color = GoldPrimary,
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                AboutCard(
                    title = "Doel van de app",
                    body  = "Islam Quiz NL is bedoeld om islamitische kennis op een leerzame en toegankelijke manier te testen. De app is geschikt voor moslims van alle niveaus die hun kennis willen verbreden over onderwerpen als de Qur'an, hadith, het gebed, de profeten en islamitisch karakter."
                )

                AboutCard(
                    title = "Geen vervanging voor onderwijs",
                    body  = "Deze app is geen vervanging voor authentiek islamitisch onderwijs. De vragen zijn bedoeld als beginpunt voor leren — niet als definitieve of uitputtende bron van kennis."
                )

                AboutCard(
                    title = "Bij twijfel: raadpleeg geleerden",
                    body  = "Bij vragen over islamitische regels, fiqh of aqeedah dien je altijd betrouwbare en gekwalificeerde islamitische geleerden te raadplegen. Wat je in deze app leest is een vereenvoudigde weergave en kan niet alle nuances bevatten."
                )

                AboutCard(
                    title = "Fiqh-kwesties",
                    body  = "Op het gebied van fiqh (islamitisch recht) bestaan soms meningsverschillen tussen de rechtsscholen. De app presenteert geen specifieke madhhab-mening als de enige waarheid. Vragen over fiqh zijn bewust algemeen en neutraal gehouden."
                )

                AboutCard(
                    title = "Geen echt geld",
                    body  = "De punten in deze app zijn puur voor de lering en het spelplezier. Er worden geen echte geldprijzen uitgekeerd. Deelname is geheel vrijblijvend."
                )

                AboutCard(
                    title = "Privacy",
                    body  = "De app verzamelt geen persoonlijke gegevens. Scores worden alleen lokaal op jouw apparaat opgeslagen."
                )

                Spacer(Modifier.height(8.dp))
                Text(
                    "Versie 1.0 • Islam Quiz NL",
                    color = Color.White.copy(alpha = 0.3f),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun AboutCard(title: String, body: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.07f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, color = GoldPrimary, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(6.dp))
            Text(body, color = Color.White.copy(alpha = 0.8f),
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp))
        }
    }
}
