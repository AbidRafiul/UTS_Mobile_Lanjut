package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GuessDao {
    @Query("SELECT * FROM correct_words")
    fun getAll(): Flow<List<CorrectWord>>

    @Insert
    suspend fun insert(word: CorrectWord)
}