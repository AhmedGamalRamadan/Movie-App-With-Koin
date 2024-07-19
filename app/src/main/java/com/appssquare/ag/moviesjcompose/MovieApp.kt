package com.appssquare.ag.moviesjcompose

import android.app.Application
import com.appssquare.ag.moviesjcompose.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApp)
            modules(listOf(appModule))
        }
    }
}