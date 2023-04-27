package com.developerscracks.movieapppruebatecnica.ui.screens.detailmovie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.developerscracks.movieapppruebatecnica.R
import com.developerscracks.movieapppruebatecnica.databinding.FragmentMovieDetailBinding
import com.developerscracks.movieapppruebatecnica.ui.screens.detailmovie.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val args: MovieDetailFragmentArgs by navArgs()

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMovieDetail(args.id)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetailMovie()
    }

    private fun showDetailMovie(){
        viewModel.movie.observe(viewLifecycleOwner){ movie->
            binding.apply {
                Glide.with(requireContext())
                    .load(movie.backdrop_path)
                    .into(ivBackgroundPosterMovie)
                Glide.with(requireContext())
                    .load(movie.poster_path)
                    .into(ivMovie)
                tvTitleMovie.text = movie.title
                tvVoteAverageMovie.text =  movie.vote_average.toString()
                rbVoteAverageMovie.rating = movie.vote_average / 2
                tvDescriptionMovie.text = movie.overview

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}