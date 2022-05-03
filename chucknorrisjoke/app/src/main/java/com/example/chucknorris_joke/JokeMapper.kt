package com.example.chucknorris_joke

import com.example.chucknorris_joke.domain.Joke

object JokeMapper {

    fun toDomain(jokeModel: JokeModel) : Joke {
        return Joke(
            value = jokeModel.value
        )
    }
}