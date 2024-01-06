package com.example.coursework.app.di

import com.example.coursework.domain.usecases.GetStockDescriptionBdUseCase
import com.example.coursework.domain.usecases.GetStockDescriptionFavoritesUseCase
import com.example.coursework.domain.usecases.GetStockDescriptionFromStockResponseUseCase
import com.example.coursework.domain.usecases.GetTopStocksTicketUseCase
import com.example.coursework.domain.usecases.SaveStockDescriptionBdUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetStockDescriptionFromStockResponseUseCase(get()) }
    factory { GetTopStocksTicketUseCase(get(), get(), get(), get()) }
    factory { GetStockDescriptionBdUseCase(get()) }
    factory { SaveStockDescriptionBdUseCase(get()) }
    factory { GetStockDescriptionFavoritesUseCase(get()) }
}