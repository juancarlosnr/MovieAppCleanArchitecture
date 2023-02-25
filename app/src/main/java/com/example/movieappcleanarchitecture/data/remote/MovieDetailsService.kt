package com.example.movieappcleanarchitecture.data.remote

import com.example.movieappcleanarchitecture.data.model.Movie
import com.example.movieappcleanarchitecture.data.model.MovieBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailsService @Inject constructor(private val api: MovieDetailsApiClient) {
    suspend fun getDetailsMovie(name:String): MovieBody {
        return withContext(Dispatchers.IO){
            val response = api.getDetailsMovie("movie/${name}?api_key=8acf57bf61daa24691dfb61c7f3c36cf")
            response.body() ?: MovieBody(0,"","","", "")
        }
    }
}