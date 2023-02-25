package com.example.movieappcleanarchitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.data.model.MovieProvider
import com.example.movieappcleanarchitecture.domain.GetPopularMoviesUseCase
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    val movieModel = MutableLiveData<List<MovieBody>>()
    var getPopularMoviesUseCase = GetPopularMoviesUseCase()
    fun onCreate() {
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            if(!result?.movies.isNullOrEmpty()){
                movieModel.postValue(result?.movies ?: emptyList())
            }
        }
    }
}