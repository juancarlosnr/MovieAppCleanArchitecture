package com.example.movieappcleanarchitecture.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.domain.model.MovieItem
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popularmovies_table")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")var id:Int,
    @ColumnInfo(name = "title")var title:String,
    @ColumnInfo(name = "original_title")var original_title:String,
    @ColumnInfo(name = "poster_path")var poster_path:String = "",
)

fun MovieBodyItem.toDatabase() = MovieEntity(id, title,original_title, poster_path)