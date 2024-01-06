package com.example.coursework.precentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.usecases.GetStockDescriptionFavoritesUseCase
import com.example.coursework.domain.usecases.GetStockDescriptionFromStockResponseUseCase
import com.example.coursework.domain.usecases.SaveStockDescriptionBdUseCase
import com.example.coursework.domain.utils.Rezult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
class StocksFavoriteViewModel(
    private val getTopStocksTicketUseCase: GetStockDescriptionFavoritesUseCase,
    private val saveStockDescriptionBdUseCase: SaveStockDescriptionBdUseCase,
    private val getStockDescriptionFromStockResponseUseCase: GetStockDescriptionFromStockResponseUseCase
) : ViewModel() {
    private val timeUpdate: Long = 60_005
    private val _topopStocks = MutableSharedFlow<Rezult<List<StockDescription>>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val topStocks: SharedFlow<Rezult<List<StockDescription>>> = _topopStocks
    fun getTopStocks() {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                when (val result = getTopStocksTicketUseCase()) {
                    is Rezult.Success -> {
                        _topopStocks.tryEmit(Rezult.Success(result.data))
                    }
                    is Rezult.Error -> {}
                }
                delay(timeUpdate)
            }
        }
    }
    fun saveStockDescriptionBd(ticket: String, favorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getStockDescriptionFromStockResponseUseCase(ticket)) {
                is Rezult.Error -> {
                }
                is Rezult.Success -> {
                    val s = result.data
                    s.favorit = favorite
                    saveStockDescriptionBdUseCase(s)
                }
            }
        }
    }
}