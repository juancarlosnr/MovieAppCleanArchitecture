package com.example.movieappcleanarchitecture.data.remote

import com.example.movieappcleanarchitecture.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieApiClient {
    @GET
    suspend fun getPopularMovies(@Url url:String): Response<Movie>
    @GET
    suspend fun getMoviesByName(@Url url:String):Response<Movie>
}