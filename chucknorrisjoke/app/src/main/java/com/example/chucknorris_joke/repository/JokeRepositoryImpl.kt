package com.example.chucknorris_joke.repository

import com.example.chucknorris_joke.data.JokeDataSource

class JokeRepositoryImpl(private val jokeDataSource: JokeDataSource) : JokeRepository {
    override suspend fun getApiJoke() = jokeDataSource.getJoke()

}