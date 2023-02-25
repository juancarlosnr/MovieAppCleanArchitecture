package com.example.movieappcleanarchitecture.data.model


import com.google.gson.annotations.SerializedName

data class Movie(
    var page:Int,
    @SerializedName("results")var movies:List<MovieBody>,
    var total_results:Int,
    var total_pages:Int
)

data class MovieBody(
    var id:Int,
    var title:String,
    var original_title:String,
    var poster_path:String
)

