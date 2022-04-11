package com.example.chucknorris_joke

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var jokeModel: JokeModel? = null
    var fact: TextView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fact = findViewById(R.id.fact)
        fact?.setText("Joke")

        button = findViewById(R.id.button)
        button?.setText("Next")

        button?.setOnClickListener {
            getData()
        }

    }

    fun getData() {
        val retrofitClient =
            NetworkUtils.getRetrofitInstance("https://api.chucknorris.io/") //criando um cliente Retrofit / Gson transforma a resposta do servidor em umobjeto que é o cliente Retrofit

        val endpoint =
            retrofitClient.create(Endpoint::class.java)  // o cliente retrofit vai criar um endpoint, que é uma implementação da Interface.
        val callback =
            endpoint.getJokes() //retorna a callback lá da Interface, que é a lista com os objetos da modelo.

        callback.enqueue(object : Callback<JokeModel> {
            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                jokeModel = response.body()
                updateJoke()
//              fact.setText(response.body()?.value)
            }
        })
    }

    fun updateJoke() {
        fact?.setText(jokeModel?.value)
    }

}
    