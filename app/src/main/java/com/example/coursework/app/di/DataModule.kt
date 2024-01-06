package com.example.coursework.app.di

import com.example.coursework.data.database.DatabaseAgent
import com.example.coursework.data.database.entity.StockDescriptionSource
import org.koin.dsl.module

val dataModule = module {
    single {
        StockDescriptionSource(DatabaseAgent.api.stockDescriptionDao())
    }
}