package com.example.coursework.data.database

import androidx.room.Room
import com.example.coursework.app.App
object DatabaseAgent {

    val api: DatabaseApi by lazy {
        return@lazy Room.databaseBuilder(
            App.app,
            DatabaseApi::class.java, "bd"
        )
            .setTransactionExecutor(App.executors)
            .setQueryExecutor(App.executors)
            .fallbackToDestructiveMigration()
            .build()
    }
}