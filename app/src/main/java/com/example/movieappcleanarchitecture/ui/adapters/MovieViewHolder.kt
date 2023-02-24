package com.example.movieappcleanarchitecture.ui.adapters

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappcleanarchitecture.databinding.ItemMovieBinding
import com.example.movieappcleanarchitecture.model.MovieBody


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMovieBinding.bind(view)


    fun render(movie: MovieBody) {
        Log.d("tituloMovie", movie.title)
        binding.tvTitle.text = movie.title
        binding.tvRealTitle.text = movie.original_title
        //Glide.with(binding.ivMovie).load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(binding.ivMovie)
    }
}