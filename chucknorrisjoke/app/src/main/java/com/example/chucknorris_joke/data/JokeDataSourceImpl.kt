package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.endpoint.JokeMapper
import com.example.chucknorris_joke.endpoint.JokeService

class JokeDataSourceImpl(private val jokeService: JokeService) : JokeDataSource {

    override suspend fun getJoke() = JokeMapper.toDomain(jokeService.getJoke())


}