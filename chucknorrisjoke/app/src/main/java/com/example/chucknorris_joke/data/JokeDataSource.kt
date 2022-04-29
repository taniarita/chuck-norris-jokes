package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.JokeModel
import retrofit2.Call

interface JokeDataSource {

    suspend fun getJoke() : Call<JokeModel>
}