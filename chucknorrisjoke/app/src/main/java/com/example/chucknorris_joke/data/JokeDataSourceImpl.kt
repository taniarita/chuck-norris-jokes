package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.Service

class JokeDataSourceImpl(private val jokeService: Service) : JokeDataSource {

    override suspend fun getJoke() = jokeService.getJoke()

}