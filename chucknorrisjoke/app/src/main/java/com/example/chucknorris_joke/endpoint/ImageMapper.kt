package com.example.chucknorris_joke.endpoint

import com.example.chucknorris_joke.domain.Image
import com.example.chucknorris_joke.models.JokeModel

object ImageMapper {

    fun toDomain(jokeModel: JokeModel) : Image {
        return Image(
            icon = jokeModel.icon
        )
    }
}