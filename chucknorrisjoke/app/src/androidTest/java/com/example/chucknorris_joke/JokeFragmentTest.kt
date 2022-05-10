package com.example.chucknorris_joke

import android.os.Bundle
import android.support.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.repository.JokeRepository
import com.example.chucknorris_joke.repository.JokeRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    private val jokeRepository: JokeRepositoryImpl = mockk(relaxed = true)

    fun getModule() = module(override = true) {

        factory<JokeRepository> { jokeRepository }
    }

    inline fun <reified F : Fragment> launchFragment(
        fragmentArgs: Bundle? = null,
        @StyleRes themeResId: Int = R.style.Theme_Chucknorrisjoke,
        factory: FragmentFactory? = null,
        crossinline action: ((fragment: FragmentScenario<F>) -> Unit) = { }
    ) = FragmentScenario.launchInContainer(F::class.java, fragmentArgs, themeResId, factory).apply {
        action(this)
    }


    @Before
    fun setup() {
        loadKoinModules(getModule())
        coEvery { jokeRepository.getApiJoke() } returns Joke("Joke")
    }

    @After
    fun clear() {
        unloadKoinModules(getModule())
    }

    @Test
    fun testeDeInterface() {
        //GIVEN
        launchFragment<JokeFragment>()
        val joke = Joke("Joke")

        //WHEN
        onView(withId(R.id.button))
            .perform(click())

        //THEN
        onView(withId(R.id.fact))
            .check(matches(withText(joke.value)))
    }
}