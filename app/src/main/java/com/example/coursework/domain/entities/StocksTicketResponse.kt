package com.example.coursework.domain.entities

import com.google.gson.annotations.SerializedName
data class StocksTicketResponse(
    @SerializedName("top_gainers")
    val names: List<StockNameResponse>
)