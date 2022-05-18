package com.example.chucknorris_joke.endpoint

import com.example.chucknorris_joke.models.JokeModel
import retrofit2.http.GET

interface JokeService {

    @GET("random")
    suspend fun getJoke(): JokeModel

//    @GET("random")
//    suspend fun getJokeByCategory(
//        @Query("category") category: String = "food"
//    ): JokeModel

}
