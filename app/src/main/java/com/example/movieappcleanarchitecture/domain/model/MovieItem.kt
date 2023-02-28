package com.example.movieappcleanarchitecture.domain.model

import com.example.movieappcleanarchitecture.data.database.entities.MovieEntity
import com.example.movieappcleanarchitecture.data.database.entities.MovieFavouriteEntity
import com.example.movieappcleanarchitecture.data.model.Movie
import com.example.movieappcleanarchitecture.data.model.MovieBody

data class MovieItem(
    var page:Int,
    var movies:List<MovieBodyItem>,
    var total_results:Int,
    var total_pages:Int
)
data class MovieBodyItem(
    var id:Int,
    var title:String,
    var original_title:String,
    var poster_path:String = ""
)

fun Movie.toDomain() = MovieItem(page,movies.map { it.toMovieBodyItem() },total_results, total_pages)
fun MovieEntity.toDomain() = MovieBodyItem(id,title,original_title, poster_path)
fun MovieFavouriteEntity.toDomain() = MovieBodyItem(id, title, original_title, poster_path)
fun MovieBody.toMovieBodyItem() = MovieBodyItem(id,title,original_title, poster_path)