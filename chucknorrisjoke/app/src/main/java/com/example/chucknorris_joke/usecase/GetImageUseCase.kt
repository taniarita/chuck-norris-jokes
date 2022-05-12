package com.example.chucknorris_joke.usecase

import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.repository.JokeRepository
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class GetImageUseCase(

    private val imageRepository: JokeRepository

) {

    suspend operator fun invoke(
        onSucess : (image : Joke) -> Unit = {},
        onError : (errorMessage: String) -> Unit = {}

    ){
        try {
            onSucess(imageRepository.getApiImage())
        }catch (e: Exception) {
            val errorMessage = when (e) {
                is UnknownHostException -> {
                    "Não encontrado!"
                }
                is TimeoutException -> {
                    "Tempo expirado!"
                }
                else -> {
                    "Erro genérico!"
                }
            }
            onError(errorMessage)

        }

    }
}