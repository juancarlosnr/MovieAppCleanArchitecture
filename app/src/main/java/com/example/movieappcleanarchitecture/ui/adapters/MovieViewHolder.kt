package com.example.movieappcleanarchitecture.ui.adapters

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappcleanarchitecture.R
import com.example.movieappcleanarchitecture.databinding.ItemMovieBinding
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.ui.view.DetailsActivity


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMovieBinding.bind(view)


    fun render(movie: MovieBodyItem) {
        binding.tvTitle.text = movie.title
        binding.tvRealTitle.text = movie.original_title
        if(!movie.poster_path.isNullOrEmpty()){
            Glide.with(binding.ivMovie).load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(binding.ivMovie)
        }else{
            binding.ivMovie.setBackgroundColor(R.drawable.ic_launcher_background)
        }

        itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(binding.ivMovie.context, DetailsActivity::class.java).apply {
                putExtra("idPelicula", movie.id.toString())
            }
            binding.ivMovie.context.startActivity(intent)
        })
    }
}