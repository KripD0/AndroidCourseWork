package com.example.coursework.domain.usecases

import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.entities.StockIntroDayResponse
import com.example.coursework.domain.entities.StockOverviewResponse
import com.example.coursework.domain.repository.Repository
import com.example.coursework.domain.utils.Reazon
import com.example.coursework.domain.utils.Rezult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
class GetStockDescriptionFromStockResponseUseCase(private val repository: Repository) {
    suspend operator fun invoke(ticket: String): Rezult<StockDescription> {
        val stockOverview = getStockOverviewResponse(repository.getStockOverview(ticket))
        val stockIntroDay = getStockIntroDayResponse(repository.getStockIntroDay(ticket))
        val stockPriseResponse =
            stockIntroDay?.timeValuePriseResponse?.getValue(stockIntroDay.stockResponse.lastRefreshed)
        if (stockOverview == null || stockIntroDay == null)
            return Rezult.Error(Reazon.NULL_DATA)
        return Rezult.Success(
            StockDescription(
                ticket = stockIntroDay.stockResponse?.name ?: "",
                lastRefreshed = stockIntroDay.stockResponse?.lastRefreshed ?: "",
                timeZone = stockIntroDay.stockResponse?.timeZone ?: "",
                price = stockPriseResponse?.price ?: "",
                volume = stockPriseResponse?.volume ?: "",
                sector = stockOverview.sector ?: "",
                pe = stockOverview.pe ?: "",
                ps = stockOverview.ps ?: "",
                ebida = stockOverview.ebida ?: "",
                capitalization = stockOverview.capitalization ?: "",
                favorit = false
            )
        )
    }
    private suspend fun getStockIntroDayResponse(stockIntroDay: Rezult<StockIntroDayResponse>): StockIntroDayResponse? {
        var stockIntroDayResponse: StockIntroDayResponse? = null
        coroutineScope {
            launch(Dispatchers.IO) {
                stockIntroDayResponse = when (stockIntroDay) {
                    is Rezult.Success -> stockIntroDay.data
                    is Rezult.Error -> null
                }

            }
        }
        return stockIntroDayResponse
    }
    private suspend fun getStockOverviewResponse(stockOverview: Rezult<StockOverviewResponse>): StockOverviewResponse? {
        var stockOverviewResponse: StockOverviewResponse? = null
        coroutineScope {
            launch(Dispatchers.IO) {
                stockOverviewResponse = when (stockOverview) {
                    is Rezult.Success -> stockOverview.data
                    is Rezult.Error -> null
                }
            }
        }
        return stockOverviewResponse
    }
}