package com.example.movieappcleanarchitecture.data

import android.util.Log
import com.example.movieappcleanarchitecture.data.database.dao.MovieDao
import com.example.movieappcleanarchitecture.data.database.entities.MovieEntity
import com.example.movieappcleanarchitecture.data.database.entities.MovieFavouriteEntity
import com.example.movieappcleanarchitecture.data.model.Movie
import com.example.movieappcleanarchitecture.data.model.MovieProvider
import com.example.movieappcleanarchitecture.data.remote.MovieService
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.domain.model.MovieItem
import com.example.movieappcleanarchitecture.domain.model.toDomain
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val api: MovieService,
    private val movieProvider: MovieProvider,
    private val movieDao: MovieDao
) {
    suspend fun getPopularMoviesFromApi(): MovieItem {
        val response: Movie = api.getPopularMovies()
        return response.toDomain()
    }

    suspend fun getPopularMoviesFromDatabase(): List<MovieBodyItem> {
        val response = movieDao.getPopularMovies()
        if(!response.isNullOrEmpty()){
            return response.map { it.toDomain() }
        }else{
            return emptyList()
        }

    }

    suspend fun insertPopularMovies(movies: List<MovieEntity>) {
        movieDao.insertPopularMovies(movies)
    }

    suspend fun insertFavoriteMovie(movie:MovieFavouriteEntity){
        movieDao.insertFavouriteMovie(movie)
    }

    suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }
    suspend fun getMovieByName(name: String): MovieItem {
        val response = api.getMovieByName(name)
        Log.d("repuestaCliente", response.movies.toString())
        movieProvider.movies = response
        if (response != null){
             return response.toDomain()
        }else{
            return MovieItem(0, emptyList(), 0, 0)
        }
    }
}
