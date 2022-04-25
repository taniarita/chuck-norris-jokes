package com.example.chucknorris_joke

import android.app.Application
import com.example.chucknorris_joke.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JokeApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@JokeApplication)

            modules(mainModule)
        }
    }
}