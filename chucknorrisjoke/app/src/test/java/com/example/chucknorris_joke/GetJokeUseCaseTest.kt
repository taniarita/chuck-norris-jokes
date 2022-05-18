package com.example.chucknorris_joke

import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.repository.JokeRepository
import com.example.chucknorris_joke.usecase.GetJokeUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.net.UnknownHostException

class GetJokeUseCaseTest {


    class GetJokeUseCaseTest {

        val jokeRepository: JokeRepository = mockk(relaxed = true)
        val onSuccess: (joke: Joke) -> Unit = mockk(relaxed = true)
        val onError: (errorMessage: String) -> Unit = mockk(relaxed = true)

        @Test
        fun `GIVEN GetJokeUseCase WHEN GetJokeUseCase is called THEN with success, repository and onSuccess are called`() {
            runBlocking {
                //GIVEN
                val getJokeUseCase = GetJokeUseCase(jokeRepository)
                val joke = Joke("", "")
                coEvery { jokeRepository.getApiJoke() } returns joke


                //WHEN
                getJokeUseCase.invoke(onSuccess = onSuccess, onError = onError)

                //THEN
                coVerify(exactly = 1) { jokeRepository.getApiJoke() }
                coVerify(exactly = 1) { onSuccess(joke) }
            }
        }

        @Test
        fun `GIVEN jokeUseCase WHEN an UnknownHostException occurs THEN onError MUST be called with this exception`() {
            runBlocking {
                //GIVEN
                val getJokeUseCase = GetJokeUseCase(jokeRepository)
                coEvery { jokeRepository.getApiJoke() } throws UnknownHostException()

                //WHEN
                getJokeUseCase(onSuccess = onSuccess, onError = onError)

                //THEN
                verify(exactly = 1) { onError(any()) }
            }
        }


        @Test
        fun `GIVEN jokeUseCase WHEN an error occurs THEN onError MUST be called with any exception`() {
            runBlocking {
                //GIVEN
                val getJokeUseCase = GetJokeUseCase(jokeRepository)
                coEvery { jokeRepository.getApiJoke() } throws Exception()

                //WHEN
                getJokeUseCase.invoke(onSuccess = onSuccess, onError = onError)

                //THEN
                verify(exactly = 1) { onError(any()) }
            }

        }
    }
}