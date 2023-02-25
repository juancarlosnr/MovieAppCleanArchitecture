package com.example.movieappcleanarchitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.domain.GetMovieByNameUseCase
import com.example.movieappcleanarchitecture.domain.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getPopularMoviesUseCase:GetPopularMoviesUseCase, private val getMovieByNameUseCase: GetMovieByNameUseCase): ViewModel() {
    val movieModel = MutableLiveData<List<MovieBody>>()

    fun onCreate() {
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            if(!result?.movies.isNullOrEmpty()){
                movieModel.postValue(result?.movies ?: emptyList())
            }
        }
    }
    fun getMovieByName(name:String){
        viewModelScope.launch {
            val result = getMovieByNameUseCase(name)

            if(!result?.movies.isNullOrEmpty()){
                movieModel.postValue(result?.movies ?: emptyList())
            }
        }
    }
}