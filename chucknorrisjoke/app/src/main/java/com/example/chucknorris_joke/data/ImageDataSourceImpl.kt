package com.example.chucknorris_joke.data

import com.example.chucknorris_joke.endpoint.ImageMapper
import com.example.chucknorris_joke.endpoint.ImageService

class ImageDataSourceImpl (private val imageService : ImageService) : ImageDataSource {

    override suspend fun getImage() = ImageMapper.toDomain(imageService.getImage())

}