package com.example.chucknorris_joke.viewModels

import android.app.Application
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
    val imageChuck = MutableLiveData<String>("")


    fun getJoke() {

        viewModelScope.launch {
            getJokeUseCase.invoke(::onSuccess, ::onError)
        }
    }

    fun onSuccess(joke : Joke) {
        currentJoke.value = joke.value
        imageChuck.value = joke.icon
    }

    fun onError(erro : String) {
        currentError.value = erro
    }

}