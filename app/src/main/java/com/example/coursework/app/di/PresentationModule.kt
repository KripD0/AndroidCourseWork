package com.example.coursework.app.di

import com.example.coursework.precentation.StockDescriptionViewModel
import com.example.coursework.precentation.StocksFavoriteViewModel
import com.example.coursework.precentation.StocksTopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { StocksTopViewModel(get(), get(), get(), get()) }
    viewModel { StockDescriptionViewModel(get(), get(), get()) }
    viewModel { StocksFavoriteViewModel(get(), get(), get()) }
}