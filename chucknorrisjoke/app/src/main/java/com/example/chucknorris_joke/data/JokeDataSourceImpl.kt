package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.endpoint.JokeMapper
import com.example.chucknorris_joke.endpoint.Service

class JokeDataSourceImpl(private val jokeService: Service) : JokeDataSource {

    override suspend fun getJoke() = JokeMapper.toDomain(jokeService.getJoke())

}