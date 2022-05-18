package com.example.chucknorris_joke.retrofitClient

import com.example.chucknorris_joke.endpoint.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitJoke {

    companion object {

        fun getRetrofitInstance(path: String): JokeService {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeService::class.java)
        }
    }
}



