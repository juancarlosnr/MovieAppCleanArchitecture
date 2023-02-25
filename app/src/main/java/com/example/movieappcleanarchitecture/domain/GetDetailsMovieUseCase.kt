package com.example.movieappcleanarchitecture.domain

import com.example.movieappcleanarchitecture.data.MovieDetailsRepository
import com.example.movieappcleanarchitecture.data.model.MovieBody
import javax.inject.Inject

class GetDetailsMovieUseCase @Inject constructor(private val repository: MovieDetailsRepository) {
    suspend operator fun invoke(name:String): MovieBody? = repository.getDetailsMovie(name)
}