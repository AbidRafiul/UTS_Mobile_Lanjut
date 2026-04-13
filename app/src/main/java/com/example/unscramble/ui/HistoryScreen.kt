package com.example.unscramble.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.unscramble.data.HistoryRepository

@Composable
fun HistoryScreen(
    repository: HistoryRepository,
    onNavigateBack: () -> Unit
) {
    val historyList by repository.allWords.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "History Jawaban Benar")

        LazyColumn(modifier = Modifier.weight(1f).padding(vertical = 8.dp)) {
            items(historyList) { item ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Text(text = item.word, modifier = Modifier.padding(16.dp))
                }
            }
        }

        Button(onClick = onNavigateBack, modifier = Modifier.fillMaxWidth()) {
            Text("Kembali ke Game")
        }
    }
}