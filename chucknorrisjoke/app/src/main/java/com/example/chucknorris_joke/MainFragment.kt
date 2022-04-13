package com.example.chucknorris_joke

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    var jokeModel: JokeModel? = null
    var fact: TextView? = null
    var button: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("MainFragment", "onCreate Called")

        val fragmentView = inflater.inflate(R.layout.fragment_main, container, false)

        fact = fragmentView.findViewById(R.id.fact)
        fact?.setText("Joke")

        button = fragmentView.findViewById(R.id.button)
        button?.setText("Next")

        button?.setOnClickListener {
            getData()
        }

        return fragmentView

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

                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()  //aqui era baseContext
            }

            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                jokeModel = response.body()
                updateJoke()
            }
        })
    }

    fun updateJoke() {
        fact?.setText(jokeModel?.value)
    }


    //Log.i nos métodos do ciclo de vida
    override fun onStart() {
        super.onStart()
        Log.i("MainFragment", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainFragment", "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainFragment", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainFragment", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainFragment", "onDestroy Called")
    }
}