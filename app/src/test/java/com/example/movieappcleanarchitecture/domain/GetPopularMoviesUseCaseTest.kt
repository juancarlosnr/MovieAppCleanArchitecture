package com.example.movieappcleanarchitecture.domain

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.movieappcleanarchitecture.data.MovieRepository
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.domain.model.MovieItem
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
 class GetPopularMoviesUseCaseTest{

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getPopularMoviesUseCase = GetPopularMoviesUseCase(movieRepository)
    }
    //Repasar este test
   /* @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {
        //Given
        coEvery { movieRepository.getPopularMoviesFromApi() } returns MovieItem(0, emptyList(), 0, 0)
        //When
        val context: Context = ApplicationProvider.getApplicationContext()
        getPopularMoviesUseCase(context)
        //Then
        coVerify(exactly = 1) { movieRepository.getPopularMoviesFromDatabase() }
    }*/

    @Test
    fun `when the api return something then get values from database`() = runBlocking {
        //Given
        val myList = listOf(MovieBodyItem(2131, "Hola", "Hola", "hdasdad"))
        coEvery { movieRepository.getPopularMoviesFromApi().movies } returns myList
        //When
        val context: Context = ApplicationProvider.getApplicationContext()
        val response = getPopularMoviesUseCase(context)
        //Then
        coVerify(exactly = 1) { movieRepository.clearMovies() }
        coVerify(exactly = 1) { movieRepository.insertPopularMovies(any()) }
        coVerify(exactly = 0) { movieRepository.getPopularMoviesFromDatabase() }
        assert(response == myList)
    }
}