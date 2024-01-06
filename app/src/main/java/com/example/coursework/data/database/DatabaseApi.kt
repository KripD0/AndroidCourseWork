package com.example.coursework.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coursework.data.database.entity.StockDescriptionDao
import com.example.coursework.data.database.entity.StockDescriptionEntity
@Database(
    entities = [
        StockDescriptionEntity::class,

    ],
    version = 1,
    exportSchema = true
)
abstract class DatabaseApi : RoomDatabase() {
    abstract fun stockDescriptionDao(): StockDescriptionDao
}