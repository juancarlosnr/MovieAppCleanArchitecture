package com.example.movieappcleanarchitecture.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappcleanarchitecture.ui.adapters.MovieAdapter
import com.example.movieappcleanarchitecture.databinding.ActivityMainBinding
import com.example.movieappcleanarchitecture.ui.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val movieViewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieViewModel.onCreate()
        movieViewModel.movieModel.observe(this, Observer {
            binding.rvMovies.layoutManager = LinearLayoutManager(this)
            binding.rvMovies.adapter = MovieAdapter(it)
            Log.d("Pruebamovie", it.toString())
        })

    }
}