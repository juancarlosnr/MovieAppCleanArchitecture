package com.example.movieappcleanarchitecture.domain

import com.example.movieappcleanarchitecture.data.MovieRepository
import com.example.movieappcleanarchitecture.data.database.entities.toFavouriteEntity
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import javax.inject.Inject

class InsertFavoriteMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend  operator fun invoke(movie: MovieBodyItem){
        repository.insertFavoriteMovie(movie.toFavouriteEntity())
    }
}