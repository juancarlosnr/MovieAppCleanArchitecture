package com.example.movieappcleanarchitecture.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappcleanarchitecture.ui.adapters.MovieAdapter
import com.example.movieappcleanarchitecture.databinding.ActivityMainBinding
import com.example.movieappcleanarchitecture.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val movieViewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Cargamos los datos principales de las películas populares
        movieViewModel.onCreate()
        //Nos quedamos observando los datos para que si hay algún cambio se lo pase al recycler view
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        movieViewModel.movieModel.observe(this, Observer {
            binding.rvMovies.adapter = MovieAdapter(it)
            Log.d("prueba", it.toString()
            )
        })
        //Buscador películas
        binding.svMovies.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                p0?.let {
                  movieViewModel.getMovieByName(it)
                }
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                p0?.let {
                    if(p0.isEmpty()){
                        movieViewModel.onCreate()
                    }
                    movieViewModel.getMovieByName(it)
                }
                return false
            }
        })


    }
}