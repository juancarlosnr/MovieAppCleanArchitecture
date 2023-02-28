package com.example.movieappcleanarchitecture.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailsProvider @Inject constructor() {
    var movie:MovieBody = MovieBody(0, "", "", "")
}