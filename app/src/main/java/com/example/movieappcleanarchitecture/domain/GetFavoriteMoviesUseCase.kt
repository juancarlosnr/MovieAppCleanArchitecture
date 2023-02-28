package com.example.movieappcleanarchitecture.domain

import android.util.Log
import com.example.movieappcleanarchitecture.data.MovieFavoritesRepository
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(private val repository: MovieFavoritesRepository) {
    suspend operator fun invoke(): List<MovieBodyItem> {
        return if (!repository.getFavoritesMovies().isNullOrEmpty()) {
            repository.getFavoritesMovies()

        }else{
            emptyList()
        }

    }
}
