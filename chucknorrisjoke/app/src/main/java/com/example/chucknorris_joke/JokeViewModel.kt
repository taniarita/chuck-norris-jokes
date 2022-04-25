package com.example.chucknorris_joke

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel(application: Application) : AndroidViewModel(application) {

    val currentJoke = MutableLiveData<String>("")

    init {
        Log.i("JokeViewModel", "JokeViewModel created!!")

    }

    fun getData(context: Context) {
        val retrofitClient =
            NetworkUtils.getRetrofitInstance("https://api.chucknorris.io/") //criando um cliente Retrofit / Gson transforma a resposta do servidor em umobjeto que é o cliente Retrofit

        val endpoint =
            retrofitClient.create(Endpoint::class.java)  // o cliente retrofit vai criar um endpoint, que é uma implementação da Interface.
        val callback =
            endpoint.getJokes() //retorna a callback lá da Interface, que é a lista com os objetos da JokeModel.

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