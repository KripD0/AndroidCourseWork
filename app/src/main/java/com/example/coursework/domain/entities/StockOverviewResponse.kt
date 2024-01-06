package com.example.coursework.domain.entities

import com.google.gson.annotations.SerializedName
data class StockOverviewResponse(
    @SerializedName("Sector")
    val sector: String,
    @SerializedName("EBITDA")
    val ebida: String,
    @SerializedName("MarketCapitalization")
    val capitalization: String,
    @SerializedName("PERatio")
    val pe: String,
    @SerializedName("EPS")
    val ps: String,
)