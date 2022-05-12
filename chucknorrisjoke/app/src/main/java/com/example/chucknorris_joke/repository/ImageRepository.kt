package com.example.chucknorris_joke.repository

import com.example.chucknorris_joke.domain.Image

interface ImageRepository {

    suspend fun getApiImage() : Image
}