package com.example.movieappcleanarchitecture.data.remote

import com.example.movieappcleanarchitecture.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api:MovieApiClient) {


    suspend fun getPopularMovies(): Movie {
        return withContext(Dispatchers.IO) {
            val response = api.getPopularMovies("movie/popular?api_key=8acf57bf61daa24691dfb61c7f3c36cf")
            response.body() ?: Movie(0, emptyList(), 0,0)
        }
    }
    suspend fun getMovieByName(name:String):Movie{
        return withContext(Dispatchers.IO){
            val response = api.getMoviesByName("search/movie?api_key=8acf57bf61daa24691dfb61c7f3c36cf&query=%24${name}")
            response.body() ?: Movie(0, emptyList(), 0,0)
        }
    }
}