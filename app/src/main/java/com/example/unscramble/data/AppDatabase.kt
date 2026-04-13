package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

@Database(entities = [CorrectWord::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun guessDao() : GuessDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "WordDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}