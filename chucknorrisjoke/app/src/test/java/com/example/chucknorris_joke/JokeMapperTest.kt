package com.example.chucknorris_joke

import com.example.chucknorris_joke.endpoint.JokeMapper
import com.example.chucknorris_joke.models.JokeModel
import io.kotest.matchers.shouldBe
import org.junit.Test

class JokeMapperTest {
    @Test
    fun `WHEN JokeMapper to domain called THEN the return is a joke value`() {
        //WHEN
        val joke = JokeMapper.toDomain(jokeModel = JokeModel(listOf(), "", "icon", "", "", "", "joke"))

        //THEN
        joke.value shouldBe "joke"
        joke.icon shouldBe "icon"
    }
}