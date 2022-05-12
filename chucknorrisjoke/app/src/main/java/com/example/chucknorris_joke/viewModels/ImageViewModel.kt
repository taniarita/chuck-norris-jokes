package com.example.chucknorris_joke.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chucknorris_joke.domain.Image
import com.example.chucknorris_joke.usecase.GetImageUseCase
import kotlinx.coroutines.launch

class ImageViewModel(

    application: Application,
    private val getImageUseCase: GetImageUseCase


) : AndroidViewModel(application) {

    val imageChuck = MutableLiveData<String>("")
    val imageError = MutableLiveData<String>("")

    fun getImage() {

        viewModelScope.launch {
            getImageUseCase.invoke(::onSuccess, ::onError)
        }
    }

    fun onSuccess(image : Image) {
        imageChuck.value = image.icon
    }

    fun onError(erro : String) {
        imageError.value = erro
    }

}