package com.example.movieappcleanarchitecture.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappcleanarchitecture.databinding.FragmentPopularBinding
import com.example.movieappcleanarchitecture.domain.model.MovieBodyItem
import com.example.movieappcleanarchitecture.ui.adapters.MovieAdapter
import com.example.movieappcleanarchitecture.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment() , MovieAdapter.onMovieClickListener{
    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = FragmentPopularBinding.bind(view)
        movieViewModel.onCreate(binding.rvMovies.context)
        //Nos quedamos observando los datos para que si hay algún cambio se lo pase al recycler view
        binding.rvMovies.layoutManager = LinearLayoutManager(binding.rvMovies.context)
        movieViewModel.movieModel.observe(viewLifecycleOwner, Observer {
            //binding.rvMovies.adapter = MovieAdapter(it)
            var adapter:MovieAdapter = MovieAdapter(it,this)
            binding.rvMovies.adapter = adapter

        })


        //Buscador películas
        binding.svMovies.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                p0?.let {
                    movieViewModel.getMovieByName(it)
                }
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                /*p0?.let {
                    if(p0.isEmpty()){
                        movieViewModel.onCreate()
                    }
                    movieViewModel.getMovieByName(it)
                }*/
                return false
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onFavouriteClick(item:MovieBodyItem) {
        movieViewModel.insertFavoriteMovie(item)
        Log.d("idFavorito", id.toString())
    }


}