package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.domain.Joke

interface JokeDataSource {

    suspend fun getJoke(): Joke



}