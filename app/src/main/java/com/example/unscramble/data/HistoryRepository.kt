package com.example.unscramble.data

import kotlinx.coroutines.flow.Flow

class HistoryRepository(private val guessDao: GuessDao) {
    val allWords: Flow<List<CorrectWord>> = guessDao.getAll()

    suspend fun insertWord(word: String) {
        guessDao.insert(CorrectWord(word = word))
    }
}