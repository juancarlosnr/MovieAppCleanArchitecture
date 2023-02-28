package com.example.movieappcleanarchitecture.data.remote

import com.example.movieappcleanarchitecture.core.Constants.API_KEY
import com.example.movieappcleanarchitecture.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api:MovieApiClient) {


    suspend fun getPopularMovies(): Movie {
        return withContext(Dispatchers.IO) {
            val response = api.getPopularMovies("movie/popular?api_key=$API_KEY")
            response.body() ?: Movie(0, emptyList(), 0,0)
        }
    }
    suspend fun getMovieByName(name:String):Movie{
        return withContext(Dispatchers.IO){
            val response = api.getMoviesByName("search/movie?api_key=$API_KEY&query=%24${name}")

            for (movie in response.body()?.movies!!){
                if (movie.poster_path.isNullOrEmpty()){
                    movie.poster_path = ""
                }
            }
            response.body() ?: Movie(0, emptyList(), 0,0)
        }
    }
}