package com.example.movieappcleanarchitecture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappcleanarchitecture.R
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem


class MovieAdapter(private var movieList: List<MovieBodyItem>, private val itemClickListener:onMovieClickListener):RecyclerView.Adapter<MovieViewHolder>(){


    interface onMovieClickListener{
        fun onFavouriteClick(item:MovieBodyItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.render(item, itemClickListener)
    }

    override fun getItemCount(): Int = movieList.size

}