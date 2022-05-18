package com.example.chucknorris_joke.repository

import com.example.chucknorris_joke.domain.Joke

interface JokeRepository {

    suspend fun getApiJoke(): Joke

}