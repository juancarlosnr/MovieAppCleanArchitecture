package com.example.movieappcleanarchitecture.data.remote

import com.example.movieappcleanarchitecture.core.RetrofitHelper
import com.example.movieappcleanarchitecture.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getPopularMovies(): Movie {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MovieApiClient::class.java).getPopularMovies("movie/popular?api_key=8acf57bf61daa24691dfb61c7f3c36cf")
            response.body() ?: Movie(0, emptyList(), 0,0)
        }
    }
}