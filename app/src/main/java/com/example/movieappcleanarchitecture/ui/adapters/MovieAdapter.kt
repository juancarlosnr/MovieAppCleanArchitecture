package com.example.movieappcleanarchitecture.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappcleanarchitecture.R
import com.example.movieappcleanarchitecture.data.model.MovieBody
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem


class MovieAdapter(private var movieList: List<MovieBodyItem>):RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int = movieList.size

}