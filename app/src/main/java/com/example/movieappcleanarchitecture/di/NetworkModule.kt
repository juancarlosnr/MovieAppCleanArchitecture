package com.example.movieappcleanarchitecture.di

import com.example.movieappcleanarchitecture.data.remote.MovieApiClient
import com.example.movieappcleanarchitecture.data.remote.MovieDetailsApiClient
import com.example.movieappcleanarchitecture.data.remote.MovieDetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieApiClient(retrofit: Retrofit):MovieApiClient{
        return retrofit.create(MovieApiClient::class.java)
    }
    @Singleton
    @Provides
    fun provideMovieDetailsApiClient(retrofit:Retrofit):MovieDetailsApiClient{
        return retrofit.create(MovieDetailsApiClient::class.java)
    }
}