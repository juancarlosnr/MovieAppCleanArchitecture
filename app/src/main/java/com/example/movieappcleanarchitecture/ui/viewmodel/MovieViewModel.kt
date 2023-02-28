package com.example.movieappcleanarchitecture.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.domain.GetMovieByNameUseCase
import com.example.movieappcleanarchitecture.domain.GetPopularMoviesUseCase
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getMovieByNameUseCase: GetMovieByNameUseCase
) : ViewModel() {
    val movieModel = MutableLiveData<List<MovieBodyItem>>()

    fun onCreate(context:Context) {
        viewModelScope.launch {
            val result = getPopularMoviesUseCase(context)
            if(!result.isNullOrEmpty()){
                movieModel.postValue(result)
            }else{
                movieModel.postValue(emptyList())
            }

        }
    }

    fun getMovieByName(name: String) {
        viewModelScope.launch {
            val result = getMovieByNameUseCase(name)
            if (!result.isNullOrEmpty()) {
                movieModel.postValue(result)
            }else{
                movieModel.postValue(emptyList())
            }

        }
    }
}