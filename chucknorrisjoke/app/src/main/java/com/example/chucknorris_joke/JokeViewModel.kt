package com.example.chucknorris_joke

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel(
        application: Application
) : AndroidViewModel(application) {

    val currentJoke = MutableLiveData<String>("")


    fun getJoke(context: Context) {
        val retrofitClient =
            RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/")

//        val service =
//            retrofitClient.create(Service::class.java)

        val callback =
            retrofitClient.getJokes()

        callback.enqueue(object : Callback<JokeModel> {
            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                currentJoke.value = response.body()?.value

            }
        })
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("JokeViewModel", "JokeViewModel destroyed!")
    }
}