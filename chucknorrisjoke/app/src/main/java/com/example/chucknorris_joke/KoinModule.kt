package com.example.chucknorris_joke.di

import com.example.chucknorris_joke.JokeViewModel
import com.example.chucknorris_joke.RetrofitClient
import com.example.chucknorris_joke.Service
import com.example.chucknorris_joke.data.JokeDataSource
import com.example.chucknorris_joke.data.JokeDataSourceImpl
import com.example.chucknorris_joke.repository.JokeRepository
import com.example.chucknorris_joke.repository.JokeRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val jokeViewModelModule = module {
    single {
        JokeViewModel(application = androidApplication(), jokeRepository = get<JokeRepository>())
    }
}

val retrofitJokeService = module {
    factory {
        RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/")
    }
}

val jokeDataSourceModule = module {
    factory<JokeDataSource> { JokeDataSourceImpl(get<Service>()) }
}

val jokeRepositoryModule = module {
    factory<JokeRepository> { JokeRepositoryImpl(get<JokeDataSource>()) }
}


