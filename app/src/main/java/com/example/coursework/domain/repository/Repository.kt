package com.example.coursework.domain.repository

import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.entities.StockIntroDayResponse
import com.example.coursework.domain.entities.StockOverviewResponse
import com.example.coursework.domain.entities.StocksTicketResponse
import com.example.coursework.domain.utils.Rezult
interface Repository {
    suspend fun getStockIntroDay(ticket: String): Rezult<StockIntroDayResponse>
    suspend fun getTopStocksTickets(): Rezult<StocksTicketResponse>
    suspend fun getStockOverview(ticket: String): Rezult<StockOverviewResponse>

    suspend fun getStockDescriptionBd(ticket: String): Rezult<StockDescription?>
    suspend fun saveStockDescriptionBd(stock: StockDescription)
    suspend fun getFavoriteStockDescription(): Rezult<List<StockDescription>>
}