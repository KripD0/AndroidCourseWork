package com.example.coursework.domain.rest.interseptors

import okhttp3.logging.HttpLoggingInterceptor
class LoggingInterceptor {
    operator fun invoke(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return loggingInterceptor
    }
}