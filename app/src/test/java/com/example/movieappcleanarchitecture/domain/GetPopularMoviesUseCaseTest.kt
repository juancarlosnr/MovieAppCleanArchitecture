package com.example.movieappcleanarchitecture.domain

import com.example.movieappcleanarchitecture.data.MovieRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before

class GetPopularMoviesUseCaseTest{
    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getPopularMoviesUseCase = GetPopularMoviesUseCase(movieRepository)
    }
    //Hacer luego cuando acabe de implementar room en el proyecto
    fun `when the api doesnt return anything then get values from database`() = runBlocking{

    }


}
