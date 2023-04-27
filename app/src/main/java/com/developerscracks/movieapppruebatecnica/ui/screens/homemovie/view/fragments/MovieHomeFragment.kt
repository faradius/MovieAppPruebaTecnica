package com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.developerscracks.movieapppruebatecnica.R
import com.developerscracks.movieapppruebatecnica.databinding.FragmentMovieHomeBinding
import com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view.adapters.MoviesTopRatedAdapter
import com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHomeFragment : Fragment() {

    private var _binding: FragmentMovieHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private val moviesTopRatedAdapter: MoviesTopRatedAdapter = MoviesTopRatedAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMoviesTopRated()
        showInfoRecyclerView()


    }

    private fun showInfoRecyclerView(){
        binding.rvTopRatedMovies.adapter = moviesTopRatedAdapter
        viewModel.movies.observe(viewLifecycleOwner){
            moviesTopRatedAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}