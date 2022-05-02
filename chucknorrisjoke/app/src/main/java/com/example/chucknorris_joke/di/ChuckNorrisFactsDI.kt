package com.example.chucknorris_joke.di//package com.example.chucknorris_joke.di
//
//import com.example.chucknorris_joke.JokeViewModel
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//import com.example.chucknorris_joke.repository.JokeRepository as JokeRepository1
//
//object ChuckNorrisFactsDI {
//    val module = module {
//        viewModel{ JokeViewModel(get())}
//        single { JokeRepository1(get()) }
//    }
//}