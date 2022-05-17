package com.example.chucknorris_joke

import android.app.Application
import com.example.chucknorris_joke.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JokeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@JokeApplication)

            modules(
                listOf(
                    jokeViewModelModule,
                    retrofitJokeService,
                    jokeRepositoryModule,
                    jokeDataSourceModule,
                    getJokeUseCase
//                    coroutine
                )
            )
        }
    }
}