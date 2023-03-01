package com.example.movieappcleanarchitecture

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.example.movieappcleanarchitecture.domain.GetMovieByNameUseCase
import com.example.movieappcleanarchitecture.domain.GetPopularMoviesUseCase
import com.example.movieappcleanarchitecture.domain.InsertFavoriteMoviesUseCase
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.domain.model.MovieItem
import com.example.movieappcleanarchitecture.ui.viewmodel.MovieViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MovieViewModelTest {
    @RelaxedMockK
    private lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @RelaxedMockK
    private lateinit var getMovieByNameUseCase: GetMovieByNameUseCase

    @RelaxedMockK
    private lateinit var insertFavoriteMovieUseCase:InsertFavoriteMoviesUseCase

    private lateinit var movieViewModel:MovieViewModel

    @Before
    fun  onBefore(){
        MockKAnnotations.init(this)
        movieViewModel = MovieViewModel(getPopularMoviesUseCase, getMovieByNameUseCase, insertFavoriteMovieUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `when viewmodel is created at the first time, get all movies and set the first value`() = runTest{
        //Given
        val movies = listOf(MovieBodyItem(0, "Test", "Test", "tesurl"), MovieBodyItem(0, "Test2", "Test2", "testurl2"))
        val context: Context = ApplicationProvider.getApplicationContext()
        coEvery { getPopularMoviesUseCase(context) } returns movies
        //When
        movieViewModel.onCreate(context)
        //Then
        movieViewModel.movieModel.value?.equals(movies)?.let { assert(it) }
    }
}