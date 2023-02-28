package com.example.movieappcleanarchitecture.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem

@Entity(tableName = "favoritemovies_table")
data class MovieFavouriteEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")var id:Int,
    @ColumnInfo(name = "title")var title:String,
    @ColumnInfo(name = "original_title")var original_title:String,
    @ColumnInfo(name = "poster_path")var poster_path:String = "",
)
fun MovieBodyItem.toFavouriteEntity() = MovieFavouriteEntity(id, title,original_title, poster_path)