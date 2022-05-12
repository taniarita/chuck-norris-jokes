package com.example.chucknorris_joke.endpoint

import com.example.chucknorris_joke.models.JokeModel
import retrofit2.http.GET

interface ImageService {
    @GET("random")
    suspend fun getImage(): JokeModel
}