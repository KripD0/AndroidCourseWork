package com.example.coursework.domain.rest

import com.example.coursework.domain.rest.interseptors.AuthInterceptor
import com.example.coursework.domain.rest.interseptors.LoggingInterceptor
import okhttp3.OkHttpClient
class OkHttpClientFactory(
    private val loggingInterceptor: LoggingInterceptor,
    private val authInterceptor: AuthInterceptor
) {
    operator fun invoke(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor())
        .addInterceptor(authInterceptor)
        .build()
}