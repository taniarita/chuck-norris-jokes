package com.example.chucknorris_joke

import retrofit2.http.GET

interface Service {

    @GET("random") //adiciona os endpoints necessários para consumir os dados da API
    suspend fun getJoke(): JokeModel// cria o endpoint que utiliza o verbo GET e retorna um objeto retrofit do tipo Call que armazena uma lista do objetos do tipo JokeModel(modelo)
}
