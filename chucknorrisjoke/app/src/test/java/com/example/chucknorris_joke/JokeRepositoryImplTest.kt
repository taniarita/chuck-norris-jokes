package com.example.chucknorris_joke

import com.example.chucknorris_joke.data.JokeDataSource
import com.example.chucknorris_joke.repository.JokeRepositoryImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class JokeRepositoryImplTest {

    val jokeDataSource: JokeDataSource = mockk(relaxed = true)

    @Test
    fun `GIVEN JokeRepository WHEN getApiJoke requested THEN getJoke MUST be called`() {
        runBlocking {
            //GIVEN
            val repository = JokeRepositoryImpl(jokeDataSource)

            //WHEN
            repository.getApiJoke()

            //THEN
            coVerify(exactly = 1) { jokeDataSource.getJoke() }
        }
    }

    @Test(expected = Exception::class)
    fun `GIVEN chuckNorrisJokeRepository WHEN getApiJoke called if an error occurs an exception MUST be thrown`() {
        runBlocking {
            //GIVEN
            val repository = JokeRepositoryImpl(jokeDataSource)
            coEvery { jokeDataSource.getJoke() } throws Exception()

            //WHEN
            repository.getApiJoke()

            //THEN
            //Expected exception
        }
    }
}