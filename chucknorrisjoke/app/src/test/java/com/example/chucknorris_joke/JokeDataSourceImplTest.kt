package com.example.chucknorris_joke

import com.example.chucknorris_joke.data.JokeDataSourceImpl
import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.endpoint.Service
import com.example.chucknorris_joke.models.JokeModel
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class JokeDataSourceImplTest {

    val jokeService: Service = mockk()

    @Test
    fun `GIVEN jokeDataSourceImpl WHEN getJoke called the return of getJoke is a joke value`() {
        runBlocking {
            //GIVEN
            val dataSource = JokeDataSourceImpl(jokeService)
            val joke = Joke("joke")
            coEvery { jokeService.getJoke() } returns JokeModel(
                listOf(),
                "",
                "",
                "",
                "",
                "",
                "joke"
            )

            //WHEN
            val result = dataSource.getJoke()

            //THEN
            result.value shouldBe joke.value
        }
    }

    @Test(expected = Exception::class)
    fun `GIVEN jokeDataSourceImpl WHEN getJoke service called if an error occurs an exception MUST be thrown`() {
        runBlocking {
            //GIVEN
            val dataSource = JokeDataSourceImpl(jokeService)
            coEvery { jokeService.getJoke() } throws Exception()

            //WHEN
            dataSource.getJoke()

            //THEN
            //Exception expected
        }
    }
}