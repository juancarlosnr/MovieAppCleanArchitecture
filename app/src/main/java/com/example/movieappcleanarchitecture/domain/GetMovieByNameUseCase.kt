package com.example.movieappcleanarchitecture.domain

import com.example.movieappcleanarchitecture.data.MovieRepository
import com.example.movieappcleanarchitecture.data.model.Movie
import javax.inject.Inject

class GetMovieByNameUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(name:String): Movie? = repository.getMovieByName(name)
}