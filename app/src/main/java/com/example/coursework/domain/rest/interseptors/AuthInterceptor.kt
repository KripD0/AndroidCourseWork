package com.example.coursework.domain.rest.interseptors

import okhttp3.Interceptor
import okhttp3.Response
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "BX88YH5Q1C77CTBY"
        val request = chain.request().newBuilder()
        token.let { request.addHeader("apikey", token) }
        return chain.proceed(request.build())
    }
}