package com.example.coursework.domain.entities

import com.google.gson.annotations.SerializedName
data class StockNameResponse(@SerializedName("ticker") val name: String)