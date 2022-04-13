package com.example.chucknorris_joke

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {  //ou FragmentActivity()?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_main, MainFragment()).commit()
    }
//
//    var jokeModel: JokeModel? = null
//    var fact: TextView? = null
//    var button: Button? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        Log.i("MainActivity", "onCreate Called")
//
//        setContentView(R.layout.activity_main)
//
//
//        fact = findViewById(R.id.fact)
//        fact?.setText("Joke")
//
//        button = findViewById(R.id.button)
//        button?.setText("Next")
//
//        button?.setOnClickListener {
//            getData()
//        }
//
//    }
//
//    fun getData() {
//        val retrofitClient =
//            NetworkUtils.getRetrofitInstance("https://api.chucknorris.io/") //criando um cliente Retrofit / Gson transforma a resposta do servidor em umobjeto que é o cliente Retrofit
//
//        val endpoint =
//            retrofitClient.create(Endpoint::class.java)  // o cliente retrofit vai criar um endpoint, que é uma implementação da Interface.
//        val callback =
//            endpoint.getJokes() //retorna a callback lá da Interface, que é a lista com os objetos da modelo.
//
//        callback.enqueue(object : Callback<JokeModel> {
//            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
//                jokeModel = response.body()
//                updateJoke()
////              fact.setText(response.body()?.value)
//            }
//        })
//    }

//    fun updateJoke() {
//        fact?.setText(jokeModel?.value)
//    }
//
//    //Log.i nos métodos do ciclo de vida
//    override fun onStart() {
//        super.onStart()
//        Log.i("MainActivity", "onStart Called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.i("MainActivity", "onResume Called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i("MainActivity", "onPause Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i("MainActivity", "onStop Called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i("MainActivity", "onDestroy Called")
//    }


        }


    