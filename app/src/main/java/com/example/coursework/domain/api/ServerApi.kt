package com.example.coursework.domain.api

import com.example.coursework.domain.entities.StockIntroDayResponse
import com.example.coursework.domain.entities.StockOverviewResponse
import com.example.coursework.domain.entities.StocksTicketResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface ServerApi {
    companion object {
        const val API_KEY = "R7GYNK7XNXKQR2E2"

        //"BX88YH5Q1C77CTBY"
        const val INTERVAL = "1min"
        const val FUNCTION = "TIME_SERIES_INTRADAY"
    }
    @GET("query")
    suspend fun getStockIntroDay(
        @Query("function") function: String = "TIME_SERIES_INTRADAY",
        @Query("symbol") symbol: String,
        @Query("interval") interval: String = INTERVAL,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<StockIntroDayResponse>
    @GET("query")
    suspend fun getTopStocks(
        @Query("function") function: String = "TOP_GAINERS_LOSERS",
        @Query("apikey") apiKey: String = API_KEY
    ): Response<StocksTicketResponse>
    @GET("query")
    suspend fun getStockOverview(
        @Query("symbol") symbol: String,
        @Query("function") function: String = "OVERVIEW",
        @Query("apikey") apiKey: String = API_KEY
    ): Response<StockOverviewResponse>
}