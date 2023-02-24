package com.example.movieappcleanarchitecture.model

class MovieProvider {
    companion object {

        fun getAllMovies(): List<MovieBody> {
            return movies
        }
        private val movies = listOf<MovieBody>(
            MovieBody(1, "PruebaTitulo", "PruebaTituloOriginal", "PruebaPoster"),
            MovieBody(2, "PruebaTitulo2", "PruebaTituloOriginal2", "PruebaPoster2"),
            MovieBody(3, "PruebaTitulo3", "PruebaTituloOriginal3", "PruebaPoster3"),
            MovieBody(4, "PruebaTitulo4", "PruebaTituloOriginal4", "PruebaPoster4"),
            MovieBody(5, "PruebaTitulo5", "PruebaTitulo", "Prueba")
        )
    }
}