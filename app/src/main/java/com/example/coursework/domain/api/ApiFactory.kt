package com.example.coursework.domain.api

import com.example.coursework.domain.rest.RetrofitFactory
class ApiFactory(private val retrofitFactory: RetrofitFactory) {

    val serverApi: ServerApi =
        retrofitFactory().create(ServerApi::class.java)
}