package com.example.coursework.data.repositoryImp

import com.example.coursework.data.database.entity.StockDescriptionSource
import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.api.ServerApi
import com.example.coursework.domain.entities.StockIntroDayResponse
import com.example.coursework.domain.entities.StockOverviewResponse
import com.example.coursework.domain.entities.StocksTicketResponse
import com.example.coursework.domain.repository.Repository
import com.example.coursework.domain.utils.Rezult
import com.example.coursework.domain.utils.safeHttpResult
class RepositoryImpl(
    private val api: ServerApi,
    private val stockDescriptionSource: StockDescriptionSource
) : Repository {
    override suspend fun getStockIntroDay(ticket: String): Rezult<StockIntroDayResponse> {
        return when (val result = safeHttpResult { api.getStockIntroDay(symbol = ticket) }) {
            is Rezult.Success -> {
                Rezult.Success(result.data)
            }
            is Rezult.Error -> {
                Rezult.Error(result.exception)
            }
        }
    }
    override suspend fun getTopStocksTickets(): Rezult<StocksTicketResponse> {
        return when (val result = safeHttpResult { api.getTopStocks() }) {
            is Rezult.Success -> {
                Rezult.Success(result.data)
            }
            is Rezult.Error -> {
                Rezult.Error(result.exception)
            }
        }
    }
    override suspend fun getStockOverview(ticket: String): Rezult<StockOverviewResponse> {
        return when (val result = safeHttpResult { api.getStockOverview(ticket) }) {
            is Rezult.Success -> {
                Rezult.Success(result.data)
            }
            is Rezult.Error -> {
                Rezult.Error(result.exception)
            }
        }
    }
    override suspend fun getStockDescriptionBd(ticket: String): Rezult<StockDescription?> {
        return when (val result = stockDescriptionSource.get(ticket)) {
            is Rezult.Success -> {
                Rezult.Success(result.data)
            }
            is Rezult.Error -> {
                Rezult.Error(result.exception)
            }
        }
    }
    override suspend fun saveStockDescriptionBd(stock: StockDescription) {
        stockDescriptionSource.save(stock)
    }
    override suspend fun getFavoriteStockDescription(): Rezult<List<StockDescription>> {
        return when (val result = stockDescriptionSource.getAll()) {
            is Rezult.Success -> {
                Rezult.Success(result.data.filter { it.favorit })
            }
            is Rezult.Error -> {
                Rezult.Error(result.exception)
            }
        }
    }
}