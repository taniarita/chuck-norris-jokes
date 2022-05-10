package com.example.chucknorris_joke.usecase

import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.repository.JokeRepository
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class GetJokeUseCase(
    private val jokeRepository: JokeRepository
//    private val coroutine: Coroutine
) {

    suspend operator fun invoke(
        onSuccess: (joke: Joke) -> Unit = {},
        onError: (errorMessage: String) -> Unit = {}
    ) {

        try {
            onSuccess(jokeRepository.getApiJoke())
        } catch (e: Exception) {
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