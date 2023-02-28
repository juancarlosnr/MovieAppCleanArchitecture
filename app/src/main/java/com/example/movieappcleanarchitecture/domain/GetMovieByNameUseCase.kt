package com.example.movieappcleanarchitecture.domain

import android.util.Log
import com.example.movieappcleanarchitecture.data.MovieRepository
import com.example.movieappcleanarchitecture.data.database.entities.toDatabase
import com.example.movieappcleanarchitecture.data.model.Movie
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import javax.inject.Inject

class GetMovieByNameUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(name:String):List<MovieBodyItem>{
        val movies = repository.getMovieByName(name).movies
        Log.d("movies", movies.toString())
        return if(!movies.isNullOrEmpty()){
            movies
        }else{
            emptyList()
        }
    }

}