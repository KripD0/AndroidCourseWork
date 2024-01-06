package com.example.coursework.app

import android.app.Application
import com.example.coursework.app.di.dataModule
import com.example.coursework.app.di.networkModule
import com.example.coursework.app.di.presentationModule
import com.example.coursework.app.di.useCasesModule
import com.orhanobut.hawk.BuildConfig
import com.orhanobut.hawk.Hawk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
class App : Application() {
    companion object {
        lateinit var app: App
        lateinit var executors: ExecutorService
    }
    override fun onCreate() {
        super.onCreate()
        app = this
        executors = Executors.newCachedThreadPool()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(app)
            modules(listOf(dataModule, networkModule, useCasesModule, presentationModule))
        }
        Hawk.init(applicationContext).build()
    }
}