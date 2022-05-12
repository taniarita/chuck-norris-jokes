package com.example.chucknorris_joke.endpoint

import com.example.chucknorris_joke.models.JokeModel
import retrofit2.http.GET

interface JokeService {

    @GET("random")
    suspend fun getJoke(): JokeModel
    suspend fun getImage(): JokeModel
}
