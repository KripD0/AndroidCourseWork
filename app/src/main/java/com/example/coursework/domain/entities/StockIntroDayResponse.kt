package com.example.coursework.domain.entities

import com.google.gson.annotations.SerializedName
data class StockIntroDayResponse(
    @SerializedName("Meta Data")
    val stockResponse: StockResponse,
    @SerializedName("Time Series (1min)")
    val timeValuePriseResponse: Map<String, PriseResponse>
)