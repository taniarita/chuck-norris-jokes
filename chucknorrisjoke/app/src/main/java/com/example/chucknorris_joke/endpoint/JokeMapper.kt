package com.example.chucknorris_joke.endpoint

import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.models.JokeModel

object JokeMapper {

    fun toDomain(jokeModel: JokeModel) : Joke {
        return Joke(
            value = jokeModel.value,
            icon = jokeModel.icon
        )
    }
}