package com.example.movieappcleanarchitecture.data

import android.util.Log
import com.example.movieappcleanarchitecture.data.database.dao.MovieDao
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.domain.model.toDomain
import javax.inject.Inject

class MovieFavoritesRepository @Inject constructor(private val movieDao: MovieDao) {
    suspend fun getFavoritesMovies(): List<MovieBodyItem> {
        val response = movieDao.getFavoritesMovies()
        Log.d("responseDao", response.toString())
        if (!response.isNullOrEmpty()) {
            return response.map { it.toDomain() }
        } else {
            return emptyList()
        }
    }
}