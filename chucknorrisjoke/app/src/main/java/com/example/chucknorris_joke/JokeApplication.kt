package com.example.chucknorris_joke

import android.app.Application
import com.example.chucknorris_joke.di.jokeDataSourceModule
import com.example.chucknorris_joke.di.jokeRepositoryModule
import com.example.chucknorris_joke.di.jokeViewModelModule
import com.example.chucknorris_joke.di.retrofitJokeService
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
                    jokeDataSourceModule
                )
            )
        }
    }
}