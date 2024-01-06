package com.example.coursework.domain.entities

import com.google.gson.annotations.SerializedName
data class StockResponse(
    @SerializedName("2. Symbol")
    val name: String,
    @SerializedName("3. Last Refreshed")
    val lastRefreshed: String,
    @SerializedName("6. Time Zone")
    val timeZone: String
)
