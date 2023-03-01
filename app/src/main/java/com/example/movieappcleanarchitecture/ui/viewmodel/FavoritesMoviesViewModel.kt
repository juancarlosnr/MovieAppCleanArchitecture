package com.example.movieappcleanarchitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcleanarchitecture.domain.DeleteFavoriteMovieUseCase
import com.example.movieappcleanarchitecture.domain.GetFavoriteMoviesUseCase
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesMoviesViewModel @Inject constructor(private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase, private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase):ViewModel() {
    val movieModel = MutableLiveData<List<MovieBodyItem>>()
     fun onCreate(){
        viewModelScope.launch {
            val result = getFavoriteMoviesUseCase()
            if (!result.isNullOrEmpty()) {
                movieModel.postValue(result)
            } else {
                movieModel.postValue(emptyList())
            }
        }
    }
    fun getFavoriteMovies() {
        viewModelScope.launch {
            val result = getFavoriteMoviesUseCase()
            if (!result.isNullOrEmpty()) {
                movieModel.postValue(result)
            } else {
                movieModel.postValue(emptyList())
            }

        }
    }
    fun deleteFavoriteMovie(id:Int){
        viewModelScope.launch {
            deleteFavoriteMovieUseCase(id)
        }
    }
}