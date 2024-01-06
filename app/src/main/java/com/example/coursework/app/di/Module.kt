package com.example.coursework.app.di

import com.example.coursework.data.repositoryImp.RepositoryImpl
import com.example.coursework.domain.api.ApiFactory
import com.example.coursework.domain.repository.Repository
import com.example.coursework.domain.rest.MoshiFactory
import com.example.coursework.domain.rest.OkHttpClientFactory
import com.example.coursework.domain.rest.RetrofitFactory
import com.example.coursework.domain.rest.interseptors.AuthInterceptor
import com.example.coursework.domain.rest.interseptors.LoggingInterceptor
import org.koin.dsl.module

val networkModule = module {

    single { AuthInterceptor() }

    factory { OkHttpClientFactory(get(), get()) }

    factory { RetrofitFactory(get(), get()) }

    single { LoggingInterceptor() }

    single { MoshiFactory() }

    single<Repository> {
        RepositoryImpl(get(), get())
    }

    single {
        ApiFactory(get()).serverApi
    }
}