package com.example.movieappcleanarchitecture.data

import com.example.movieappcleanarchitecture.data.model.Movie
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.data.model.MovieDetailsProvider
import com.example.movieappcleanarchitecture.data.remote.MovieDetailsService
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(private val api:MovieDetailsService, private val movieDetailsProvider: MovieDetailsProvider){
    suspend fun getDetailsMovie (name:String): MovieBody {
        val response = api.getDetailsMovie(name)
        movieDetailsProvider.movie = response
        return response
    }
}