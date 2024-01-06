package com.example.coursework.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coursework.data.entity.StockDescription
@Entity(tableName = "stockDescription")
data class StockDescriptionEntity(
    @PrimaryKey
    val ticket: String,
    val lastRefreshed: String,
    val timeZone: String,
    val price: String,
    val volume: String,
    val sector: String,
    val ebida: String,
    val capitalization: String,
    val pe: String,
    val ps: String,
    val favorit: Boolean
) {
    fun toDomain() = StockDescription(
        ticket,
        lastRefreshed,
        timeZone,
        price,
        volume,
        sector,
        ebida,
        capitalization,
        pe,
        ps,
        favorit
    )
}
