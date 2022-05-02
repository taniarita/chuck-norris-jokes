package com.example.chucknorris_joke.di

import com.example.chucknorris_joke.JokeViewModel
import com.example.chucknorris_joke.RetrofitClient
import com.example.chucknorris_joke.data.JokeDataSource
import com.example.chucknorris_joke.data.JokeDataSourceImpl
import com.example.chucknorris_joke.repository.JokeRepository
import com.example.chucknorris_joke.repository.JokeRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val jokeViewModelModule = module {
    single {
        JokeViewModel(androidApplication(), get())
    }
}

val retrofitJokeService = module {
    factory {
//            Retrofit.Builder()
//                .baseUrl("https://api.chucknorris.io/jokes/random")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(Service::class.java)
        RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/")
    }
}

val jokeDataSourceModule = module {
    factory<JokeDataSource> { JokeDataSourceImpl(get()) }
}

val jokeRepositoryModule = module {
    factory<JokeRepository> { JokeRepositoryImpl(get()) }
}



