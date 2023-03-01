package com.example.movieappcleanarchitecture.ui.adapters

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappcleanarchitecture.R
import com.example.movieappcleanarchitecture.databinding.ItemFavoritemovieBinding
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem

class MovieFavoritesViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val binding = ItemFavoritemovieBinding.bind(view)

    fun render(movie: MovieBodyItem, itemClickListener: MovieFavoritesAdapter.onMovieClickListener) {
        binding.tvTitle.text = movie.title
        binding.tvRealTitle.text = movie.original_title
        if (!movie.poster_path.isNullOrEmpty()) {
            Glide.with(binding.ivMovie).load("https://image.tmdb.org/t/p/w500/${movie.poster_path}")
                .into(binding.ivMovie)
        } else {
            binding.ivMovie.setBackgroundColor(R.drawable.ic_launcher_background)
        }
        binding.deleteFavorite.setOnClickListener {
            var item = MovieBodyItem(movie.id, movie.title,movie.original_title, movie.poster_path)
            itemClickListener.onFavouriteClick(item)
        }
    }
}