package com.example.movieappcleanarchitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappcleanarchitecture.model.MovieBody
import com.example.movieappcleanarchitecture.model.MovieProvider

class MovieViewModel: ViewModel() {
    val movieModel = MutableLiveData<List<MovieBody>>()

    fun getMovies(){
        val movies = MovieProvider.getAllMovies()
        movieModel.postValue(movies)
    }
}