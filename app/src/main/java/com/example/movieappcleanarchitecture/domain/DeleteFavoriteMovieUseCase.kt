package com.example.movieappcleanarchitecture.domain

import com.example.movieappcleanarchitecture.data.MovieFavoritesRepository
import javax.inject.Inject

class DeleteFavoriteMovieUseCase @Inject constructor(private val repository: MovieFavoritesRepository) {

    suspend  operator fun invoke(id: Int){
        repository.deleteFavoriteMovie(id)
    }
}