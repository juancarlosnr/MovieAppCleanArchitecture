package com.example.movieappcleanarchitecture.data.database

import androidx.room.Database

import androidx.room.RoomDatabase
import com.example.movieappcleanarchitecture.data.database.dao.MovieDao
import com.example.movieappcleanarchitecture.data.database.entities.MovieEntity
import com.example.movieappcleanarchitecture.data.database.entities.MovieFavouriteEntity

@Database(entities = [MovieEntity::class, MovieFavouriteEntity::class], version = 2)
abstract class MovieDatabase:RoomDatabase(){

    abstract fun getMovieDao():MovieDao
}