package com.example.movieappcleanarchitecture.model


data class Movie(var name:String)
data class MovieBody(
    var id:Int,
    var title:String,
    var original_title:String,
    var poster_path:String
)
