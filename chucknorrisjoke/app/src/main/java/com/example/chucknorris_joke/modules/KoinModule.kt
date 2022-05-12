package com.example.chucknorris_joke.di

import com.example.chucknorris_joke.core.Coroutine
import com.example.chucknorris_joke.data.ImageDataSource
import com.example.chucknorris_joke.data.ImageDataSourceImpl
import com.example.chucknorris_joke.data.JokeDataSource
import com.example.chucknorris_joke.data.JokeDataSourceImpl
import com.example.chucknorris_joke.endpoint.ImageService
import com.example.chucknorris_joke.endpoint.JokeService
import com.example.chucknorris_joke.repository.ImageRepository
import com.example.chucknorris_joke.repository.ImageRepositoryImpl
import com.example.chucknorris_joke.repository.JokeRepository
import com.example.chucknorris_joke.repository.JokeRepositoryImpl
import com.example.chucknorris_joke.retrofitClient.RetrofitClient
import com.example.chucknorris_joke.usecase.GetJokeUseCase
import com.example.chucknorris_joke.viewModels.JokeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val jokeViewModelModule = module {
    single {
        JokeViewModel(application = androidApplication(), get<GetJokeUseCase>())
    }
}

val retrofitJokeService = module {
    factory {
        RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/")
    }
}

val jokeDataSourceModule = module {
    factory<JokeDataSource> { JokeDataSourceImpl(get<JokeService>()) }
}

val jokeRepositoryModule = module {
    factory<JokeRepository> { JokeRepositoryImpl(get<JokeDataSource>()) }
}

val imageDataSourceModule = module {
    factory<ImageDataSource> { ImageDataSourceImpl(get<ImageService>())  }
}

val imageRepositoryModule = module {
    factory<ImageRepository> { ImageRepositoryImpl(get<ImageDataSource>())  }
}

val getJokeUseCase = module {
    factory<GetJokeUseCase> { GetJokeUseCase(get<JokeRepository>()) }
}

val coroutine = module {
    single{ Coroutine()} }

