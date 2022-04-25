package com.example.chucknorris_joke.di

import com.example.chucknorris_joke.JokeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        JokeViewModel(androidApplication())
    }
}


