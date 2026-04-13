package com.example.unscramble.data


import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query

@Dao
interface GuessDao {
    @Query("SELECT * FROM WordData")
    suspend fun getAll(): List<WordData>

    @Insert
    suspend fun insert(vararg CorrectWord: CorrectWord))
}