package com.example.chucknorris_joke

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chucknorris_joke.repository.JokeRepository
import kotlinx.coroutines.launch

class JokeViewModel(
    application: Application,
    private val jokeRepository: JokeRepository
) : AndroidViewModel(application) {

    val currentJoke = MutableLiveData<String>("")


    fun getJoke(context: Context) {

        viewModelScope.launch {
            currentJoke.value = jokeRepository.getJoke().value
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("JokeViewModel", "JokeViewModel destroyed!")
    }
}