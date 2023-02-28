package com.example.movieappcleanarchitecture.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieappcleanarchitecture.data.database.entities.MovieEntity
import com.example.movieappcleanarchitecture.data.database.entities.MovieFavouriteEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM popularmovies_table")
    suspend fun getPopularMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movies:List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteMovie(movie: MovieFavouriteEntity)

    @Query("SELECT * FROM favoritemovies_table")
    suspend fun getFavoritesMovies():List<MovieFavouriteEntity>

    @Query("DELETE FROM popularmovies_table")
    suspend fun deleteAllMovies()
}