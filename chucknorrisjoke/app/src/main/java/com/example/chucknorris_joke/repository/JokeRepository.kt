package com.example.chucknorris_joke.repository

import com.example.chucknorris_joke.JokeModel
import retrofit2.Call

interface JokeRepository {
    suspend fun getJoke() : Call<JokeModel>
}