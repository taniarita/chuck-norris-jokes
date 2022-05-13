package com.example.chucknorris_joke

import android.app.Application
import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.usecase.GetJokeUseCase
import com.example.chucknorris_joke.viewModels.JokeViewModel
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.invoke
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


class JokeViewModelTest {
    val getJokeUseCase: GetJokeUseCase = mockk(relaxed = true)
    val application: Application = mockk(relaxed = true)
    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `GIVEN jokeViewModel WHEN getJoke called THEN jokeUseCase called`() {
        //GIVEN
        val jokeViewModel = JokeViewModel(application, getJokeUseCase)

        //WHEN
        jokeViewModel.getJoke()

        //THEN
        coVerify(exactly = 1) { getJokeUseCase(any(), any()) }
    }

    @Test
    fun `GIVEN jokeViewModel WHEN onSucess is called THEN with success, currentJoke value should be a joke value`() {
        // GIVEN
        val jokeViewModel = JokeViewModel(application, getJokeUseCase)
        val joke = Joke("", "")

        coEvery {
            getJokeUseCase(
                onSuccess = captureLambda(),
                onError = any()
            )
        } answers { lambda<(Joke) -> Unit>().invoke(joke) }

        // WHEN
        jokeViewModel.getJoke()

        // THEN
        jokeViewModel.currentJoke.value shouldBe joke.value
    }


}


