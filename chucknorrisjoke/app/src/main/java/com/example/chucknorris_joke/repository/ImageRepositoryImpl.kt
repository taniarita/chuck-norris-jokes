package com.example.chucknorris_joke.repository

import com.example.chucknorris_joke.data.ImageDataSource

class ImageRepositoryImpl (private val imageDataSource: ImageDataSource) : ImageRepository {

    override suspend fun getApiImage() = imageDataSource.getImage()
}