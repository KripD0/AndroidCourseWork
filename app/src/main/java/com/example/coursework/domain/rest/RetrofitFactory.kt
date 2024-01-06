package com.example.coursework.domain.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitFactory(
    private val okHttpClientFactory: OkHttpClientFactory,
    private val moshiFactory: MoshiFactory
) {
    private val MAIN_SERVER_URL = "https://www.alphavantage.co/"
    operator fun invoke(): Retrofit = Retrofit.Builder()
        .baseUrl(MAIN_SERVER_URL)
        .client(okHttpClientFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
