package com.example.islamquiznl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.islamquiznl.data.QuizCategory
import com.example.islamquiznl.ui.*

private val categoryMeta = mapOf(
    QuizCategory.QURAN         to ("📖 Qur'an"             to "Kennis over de Heilige Qur'an"),
    QuizCategory.HADITH        to ("📜 Hadith"             to "Overleveringen van de Profeet ﷺ"),
    QuizCategory.PRAYER_WUDU  to ("🕌 Gebed & Wuḍū'"      to "Gebed, wuḍū' en ibādah"),
    QuizCategory.PROPHETS      to ("⭐ Profeten"            to "Verhalen van de profeten"),
    QuizCategory.SEERAH        to ("🌙 Sīrah"               to "Leven van de Profeet ﷺ"),
    QuizCategory.SAHABA        to ("🛡️ Sahāba"              to "Metgezellen van de Profeet ﷺ"),
    QuizCategory.RAMADAN       to ("🌟 Ramadan"             to "Vasten, Laylat al-Qadr en meer"),
    QuizCategory.AKHLAAQ       to ("💎 Akhlāq"              to "Islamitisch karakter en deugden"),
    QuizCategory.GENERAL       to ("🔹 Algemeen"            to "Aqeedah, fiqh en algemene kennis")
)

@Composable
fun CategoryScreen(onCategorySelected: (QuizCategory) -> Unit, onBack: () -> Unit) {
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
                Text(
                    "Kies een categorie",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(QuizCategory.values().toList()) { cat ->
                    val (title, desc) = categoryMeta[cat] ?: ("${cat.name}" to "")
                    Card(
                        onClick = { onCategorySelected(cat) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f)),
                        elevation = CardDefaults.cardElevation(0.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(title, color = GoldPrimary, fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyLarge)
                                Text(desc, color = Color.White.copy(alpha = 0.65f),
                                    style = MaterialTheme.typography.bodySmall)
                            }
                            Text("›", color = GoldPrimary.copy(alpha = 0.7f),
                                style = MaterialTheme.typography.headlineSmall)
                        }
                    }
                }
                item { Spacer(Modifier.height(16.dp)) }
            }
        }
    }
}
