package com.example.chucknorris_joke

import com.google.gson.annotations.SerializedName



    data class JokeModel(
        @SerializedName("categories")
        var categories: List<String>,
        @SerializedName("created_at")
        var createAt: String,
        @SerializedName("icon_url")
        var icon : String,
        @SerializedName("id")
        var jokeId : String,
        @SerializedName("updated_at")
        var updatedAt: String,
        @SerializedName("url")
        var url : String,
        @SerializedName("value")
        var value : String
        )


/*
    classe modelo: recebe o json e transforma em objeto;
 */