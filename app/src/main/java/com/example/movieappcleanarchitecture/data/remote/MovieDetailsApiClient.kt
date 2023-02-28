package com.example.movieappcleanarchitecture.data.remote


import com.example.movieappcleanarchitecture.data.model.MovieBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieDetailsApiClient {
    @GET
    suspend fun getDetailsMovie(@Url url:String): Response<MovieBody>
}