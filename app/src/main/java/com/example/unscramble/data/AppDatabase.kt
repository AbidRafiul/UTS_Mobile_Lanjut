package com.example.unscramble.data

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import androidx.room3.vo.Database

@Database(entities = [Character::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun GuessDao() : GuessDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "WordData" // Nama databasenya
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}