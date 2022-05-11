package com.example.chucknorris_joke.retrofitClient

import com.example.chucknorris_joke.endpoint.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance(path : String) : Service {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service::class.java)
        }
    }
}

// Essa classe configura uma instancia do Retorfit e define o endpoint base necessário para a consulta/ Vai ser instanciado no MainActivity

