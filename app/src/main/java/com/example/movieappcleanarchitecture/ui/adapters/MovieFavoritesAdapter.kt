package com.example.movieappcleanarchitecture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappcleanarchitecture.R
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem

class MovieFavoritesAdapter(private var movieList: List<MovieBodyItem>, private val itemClickListener: MovieFavoritesAdapter.onMovieClickListener):RecyclerView.Adapter<MovieFavoritesViewHolder>() {

    interface onMovieClickListener{
        fun onFavouriteClick(item:MovieBodyItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavoritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieFavoritesViewHolder(layoutInflater.inflate(R.layout.item_favoritemovie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieFavoritesViewHolder, position: Int) {
        val item = movieList[position]
        holder.render(item, itemClickListener)
    }

    override fun getItemCount(): Int = movieList.size
}