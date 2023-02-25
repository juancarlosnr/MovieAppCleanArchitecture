package com.example.movieappcleanarchitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.domain.GetDetailsMovieUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val getDetailsMovieUseCase: GetDetailsMovieUseCase):ViewModel() {
    val movie = MutableLiveData<MovieBody>()

    fun onCreate(id:String) {
        viewModelScope.launch {
            val result = getDetailsMovieUseCase(id)
            if(result != null){
                movie.postValue(result ?: null)
            }
        }
    }
}