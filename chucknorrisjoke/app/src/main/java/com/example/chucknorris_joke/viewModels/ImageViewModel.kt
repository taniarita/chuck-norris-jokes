package com.example.chucknorris_joke.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chucknorris_joke.domain.Joke
import com.example.chucknorris_joke.usecase.GetImageUseCase
import kotlinx.coroutines.launch

class ImageViewModel(

    application: Application,
    private val getImageUseCase: GetImageUseCase


) : AndroidViewModel(application) {

    val currentImageChuck = MutableLiveData<String>("")
    val currentImageError = MutableLiveData<String>("")

    fun getImage() {

        viewModelScope.launch {
            getImageUseCase.invoke(::onSuccess, ::onError)
        }
    }

    fun onSuccess(image : Joke) {
        currentImageChuck.value = image.icon
    }

    fun onError(erro : String) {
        currentImageError.value = erro
    }

}