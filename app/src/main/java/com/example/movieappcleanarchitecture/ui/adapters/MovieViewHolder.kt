package com.example.movieappcleanarchitecture.ui.adapters

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappcleanarchitecture.databinding.ItemMovieBinding
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.ui.view.DetailsActivity


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMovieBinding.bind(view)


    fun render(movie: MovieBody) {
        Log.d("tituloMovie", movie.title)
        binding.tvTitle.text = movie.title
        binding.tvRealTitle.text = movie.original_title
        Glide.with(binding.ivMovie).load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(binding.ivMovie)
        itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(binding.ivMovie.context, DetailsActivity::class.java).apply {
                putExtra("idPelicula", movie.id.toString())
            }
            Log.d("idMovie", movie.id.toString())
            binding.ivMovie.context.startActivity(intent)
        })
    }
}