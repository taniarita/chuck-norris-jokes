package com.example.chucknorris_joke

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.usecase.GetJokeUseCase
import kotlinx.coroutines.launch

class JokeViewModel(
    application: Application,
    private val getJokeUseCase: GetJokeUseCase
) : AndroidViewModel(application) {

    val currentJoke = MutableLiveData<String>("")
    val currentError = MutableLiveData<String>("")

    fun getJoke(context: Context) {

        viewModelScope.launch {
            getJokeUseCase(::onSuccess, ::onError)
        }
    }

    fun onSuccess(joke : Joke) {
        currentJoke.value = joke.value
    }

    fun onError(erro : String) {
        currentError.value = erro
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("JokeViewModel", "JokeViewModel destroyed!")
    }
}