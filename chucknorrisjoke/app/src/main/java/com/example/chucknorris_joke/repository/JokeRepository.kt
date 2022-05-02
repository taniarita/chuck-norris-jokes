package com.example.chucknorris_joke.repository

import com.example.chucknorris_joke.JokeModel

interface JokeRepository {
    suspend fun getJoke(): JokeModel
}