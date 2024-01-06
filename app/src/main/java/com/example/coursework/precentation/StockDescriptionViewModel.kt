package com.example.coursework.precentation

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.usecases.GetStockDescriptionBdUseCase
import com.example.coursework.domain.usecases.GetStockDescriptionFromStockResponseUseCase
import com.example.coursework.domain.usecases.SaveStockDescriptionBdUseCase
import com.example.coursework.domain.utils.Rezult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class StockDescriptionViewModel(
    private val getStockDescriptionFromStockResponseUseCase: GetStockDescriptionFromStockResponseUseCase,
    private val getStockDescriptionBdUseCase: GetStockDescriptionBdUseCase,
    private val saveStockDescriptionBdUseCase: SaveStockDescriptionBdUseCase
) : ViewModel() {

    var stock: ObservableField<StockDescription> = ObservableField<StockDescription>()
    private val timeUpdate: Long = 60_005
    var favorite = false
    fun getStockInfo(ticket: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val ticket1 = ticket ?: ""
            while (true) {
                when (val result = getStockDescriptionFromStockResponseUseCase(ticket1)) {
                    is Rezult.Error -> {
                        when (val stockDescriptionRezult = getStockDescriptionBdUseCase(ticket1)) {
                            is Rezult.Error -> {}
                            is Rezult.Success -> {
                                val s = stockDescriptionRezult.data
                                s!!.favorit = favorite
                                stock.set(s)
                            }
                        }
                    }
                    is Rezult.Success -> {
                        val s = result.data
                        s.favorit = favorite
                        stock.set(s)
                        saveStockDescriptionBdUseCase(result.data)
                    }
                }
                delay(timeUpdate)
            }
        }
    }
    fun saveStockDescriptionBd(favorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            stock.get()?.let {
                it.favorit = favorite
                saveStockDescriptionBdUseCase(it)
            }

        }
    }
}