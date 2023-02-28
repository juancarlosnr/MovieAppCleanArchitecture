package com.example.movieappcleanarchitecture.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.movieappcleanarchitecture.databinding.ActivityDetailsBinding
import com.example.movieappcleanarchitecture.ui.viewmodel.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idMovie: String? = intent.getStringExtra("idPelicula")
        if (idMovie != null) {
            movieDetailsViewModel.onCreate(idMovie)
        }
        movieDetailsViewModel.movie.observe(this, Observer {
            Glide.with(binding.ivMovie).load("https://image.tmdb.org/t/p/w500/${it.poster_path}").into(binding.ivMovie)
            binding.tvTitle.text = it.title
            binding.tvOriginaltitle.text = it.original_title
        })
    }
}