package com.example.movieappcleanarchitecture.ui.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappcleanarchitecture.databinding.FragmentFavoritesBinding
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.ui.adapters.MovieFavoritesAdapter
import com.example.movieappcleanarchitecture.ui.viewmodel.FavoritesMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(), MovieFavoritesAdapter.onMovieClickListener {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private val FavoriteMoviesViewModel: FavoritesMoviesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FavoriteMoviesViewModel.onCreate()
        binding.rvMovies.layoutManager = LinearLayoutManager(binding.rvMovies.context)
        FavoriteMoviesViewModel.movieModel.observe(viewLifecycleOwner, Observer {
            Log.d("pruebaFavoritos", it.toString())
            var adapter: MovieFavoritesAdapter = MovieFavoritesAdapter(it, this)
            binding.rvMovies.adapter = adapter
            adapter.notifyDataSetChanged()
        })
        binding.swipe.setOnRefreshListener {
            FavoriteMoviesViewModel.getFavoriteMovies()
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipe.isRefreshing = false
            }, 2000)
        }
    }

    override fun onFavouriteClick(item: MovieBodyItem) {
        FavoriteMoviesViewModel.deleteFavoriteMovie(item.id)
        FavoriteMoviesViewModel.getFavoriteMovies()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}