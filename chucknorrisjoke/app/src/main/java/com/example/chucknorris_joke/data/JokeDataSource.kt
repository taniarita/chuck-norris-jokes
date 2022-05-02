package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.JokeModel

interface JokeDataSource {

    suspend fun getJoke(): JokeModel
}