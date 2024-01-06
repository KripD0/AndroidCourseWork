package com.example.coursework.domain.entities

import com.google.gson.annotations.SerializedName
data class PriseResponse(
    @SerializedName("01. open")
    val open: String?,
    @SerializedName("2. high")
    val high: String?,
    @SerializedName("3. low")
    val low: String?,
    @SerializedName("4. close")
    val price: String?,
    @SerializedName("5. volume")
    val volume: String?
)