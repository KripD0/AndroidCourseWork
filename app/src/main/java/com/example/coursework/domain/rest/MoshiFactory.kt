package com.example.coursework.domain.rest

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
class MoshiFactory {
    operator fun invoke(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}