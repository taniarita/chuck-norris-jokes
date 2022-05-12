package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.domain.Image

interface ImageDataSource {
    suspend fun getImage() : Image
}