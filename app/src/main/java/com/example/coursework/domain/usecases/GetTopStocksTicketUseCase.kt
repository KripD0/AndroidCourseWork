package com.example.coursework.domain.usecases

import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.entities.StocksTicketResponse
import com.example.coursework.domain.repository.Repository
import com.example.coursework.domain.utils.Rezult
import com.example.coursework.domain.utils.safeResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
class GetTopStocksTicketUseCase(
    private val repository: Repository,
    private val getStockDescriptionFromStockResponseUseCase: GetStockDescriptionFromStockResponseUseCase,
    private val getStockDescriptionBdUseCase: GetStockDescriptionBdUseCase,
    private val saveStockDescriptionBdUseCase: SaveStockDescriptionBdUseCase,
) {
    suspend operator fun invoke(): Rezult<List<StockDescription>> {
        val stocksNames = getStocksNamesResponse(repository.getTopStocksTickets())
        val s = getStockDescription(stocksNames)
        return safeResult { s }
    }
    private suspend fun getStockDescription(stocksNames: StocksTicketResponse?): MutableList<StockDescription> {
        val stocks = mutableListOf<StockDescription>()
        // stocksNames?.names?.forEach {
        for (i in 1..5) {
            when (val r = getStockDescriptionFromStockResponseUseCase(
                stocksNames?.names?.get(i)?.name ?: ""
                // it.name
            )) {
                is Rezult.Error -> {}
                is Rezult.Success -> {

                    val s = r.data

                    when (val r = getStockDescriptionBdUseCase(s.ticket)) {
                        is Rezult.Error -> {

                        }

                        is Rezult.Success -> {
                            if (r.data != null && r.data.favorit) {
                                s.favorit = true
                            }
                        }
                    }
                    saveStockDescriptionBdUseCase(s)

                    stocks.add(r.data)
                }
            }
            //  }
        }
        return stocks
    }
    private suspend fun getStocksNamesResponse(stocksNames: Rezult<StocksTicketResponse>): StocksTicketResponse? {
        var stocksNamesResponse: StocksTicketResponse? = null
        coroutineScope {
            launch(Dispatchers.IO) {
                stocksNamesResponse = when (stocksNames) {
                    is Rezult.Success -> stocksNames.data
                    is Rezult.Error -> null
                }
            }
        }
        return stocksNamesResponse
    }
}