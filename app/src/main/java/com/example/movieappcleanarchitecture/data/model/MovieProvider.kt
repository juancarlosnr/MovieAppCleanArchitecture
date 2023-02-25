package com.example.movieappcleanarchitecture.data.model

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MovieProvider @Inject constructor(){

        var movies:Movie = Movie(0, emptyList(),0,0)
}