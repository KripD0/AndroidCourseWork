package com.example.coursework.data.database.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface StockDescriptionDao {
    @Query("SELECT * FROM stockDescription WHERE ticket = :ticket")
    suspend fun get(ticket: String): StockDescriptionEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: StockDescriptionEntity)
    @Query("DELETE FROM stockDescription WHERE ticket = :ticket")
    fun delete(ticket: String)
    @Query("SELECT * FROM stockDescription")
    fun getAll(): List<StockDescriptionEntity>
}