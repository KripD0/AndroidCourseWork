package com.example.coursework.data.entity

import com.example.coursework.data.database.entity.StockDescriptionEntity
data class StockDescription(
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
    var favorit: Boolean
) {
    fun toEntity(ticket: String) = StockDescriptionEntity(
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