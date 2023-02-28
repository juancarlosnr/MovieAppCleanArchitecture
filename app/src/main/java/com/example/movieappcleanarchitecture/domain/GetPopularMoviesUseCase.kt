package com.example.movieappcleanarchitecture.domain

import android.content.Context
import android.util.Log
import com.example.movieappcleanarchitecture.core.Network
import com.example.movieappcleanarchitecture.data.MovieRepository
import com.example.movieappcleanarchitecture.data.database.entities.toDatabase
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem

import javax.inject.Inject


class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(context:Context):List<MovieBodyItem>{


        return if(Network.checkConnectivity(context) == true){
            repository.clearMovies();
            var movies = repository.getPopularMoviesFromApi().movies
            repository.insertPopularMovies(movies.map { it.toDatabase() })
            movies
        }else{
            Log.d("Moviesdatabase","Base datos"+repository.getPopularMoviesFromDatabase().toString())
            repository.getPopularMoviesFromDatabase()
        }

    }


}