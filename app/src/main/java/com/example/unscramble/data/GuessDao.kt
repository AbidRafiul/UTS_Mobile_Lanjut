package com.example.unscramble.data


import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query

@Dao
interface GuessDao {
    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<Character>

    @Insert
    suspend fun insert(vararg character: Character)
}