package com.example.movieappcleanarchitecture.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.movieappcleanarchitecture.databinding.FragmentFavoritesBinding
import com.example.movieappcleanarchitecture.ui.viewmodel.FavoritesMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
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
        FavoriteMoviesViewModel.movieModel.observe(viewLifecycleOwner, Observer {
            Log.d("pruebaFavoritos",  it.toString())

        })
        FavoriteMoviesViewModel.getFavoriteMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}