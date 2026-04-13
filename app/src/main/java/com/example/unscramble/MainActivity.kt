package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble.data.AppDatabase
import com.example.unscramble.data.HistoryRepository
import com.example.unscramble.ui.GameScreen
import com.example.unscramble.ui.GameViewModel
import com.example.unscramble.ui.GameViewModelFactory
import com.example.unscramble.ui.HistoryScreen
import com.example.unscramble.ui.theme.UnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Database dan Repository
        val database = AppDatabase.getInstance(this)
        val repository = HistoryRepository(database.guessDao())

        setContent {
            UnscrambleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Inisialisasi ViewModel dengan Factory
                    val gameViewModel: GameViewModel = viewModel(
                        factory = GameViewModelFactory(repository)
                    )

                    // State navigasi sederhana
                    var showHistory by remember { mutableStateOf(false) }

                    if (showHistory) {
                        HistoryScreen(
                            repository = repository,
                            onNavigateBack = { showHistory = false }
                        )
                    } else {
                        // Pastikan GameScreen dimodifikasi untuk menerima fungsi onNavigateToHistory
                        GameScreen(
                            gameViewModel = gameViewModel,
                            onNavigateToHistory = { showHistory = true }
                        )
                    }
                }
            }
        }
    }
}