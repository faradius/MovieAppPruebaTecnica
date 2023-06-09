package com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.developerscracks.movieapppruebatecnica.R
import com.developerscracks.movieapppruebatecnica.databinding.FragmentMovieHomeBinding
import com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view.adapters.MoviesAdapter
import com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.viewmodel.HomeViewModel
import com.developerscracks.movieapppruebatecnica.ui.utils.hide
import com.developerscracks.movieapppruebatecnica.ui.utils.hideKeyboard
import com.developerscracks.movieapppruebatecnica.ui.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHomeFragment : Fragment() {

    private var _binding: FragmentMovieHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private val moviesTopRatedAdapter: MoviesAdapter = MoviesAdapter(
        onClick = {selectedMovie ->
            val action = MovieHomeFragmentDirections.actionMovieHomeFragmentToMovieDetailFragment(selectedMovie)
            findNavController().navigate(action)
        }
    )

    private val moviesNowPlayingAdapter: MoviesAdapter = MoviesAdapter(
        onClick = { selectedMovie ->
            val action = MovieHomeFragmentDirections.actionMovieHomeFragmentToMovieDetailFragment(selectedMovie)
            findNavController().navigate(action)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object: OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return if (query != null){
                    viewModel.getMovieByTitle(query)
                    viewModel.getMovieByTitleNowPlaying(query)
                    binding.searchView.hideKeyboard()
                    true
                }else{
                    false
                }
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return if (newText != null){
                    viewModel.getMovieByTitle(newText)
                    viewModel.getMovieByTitleNowPlaying(newText)
                    true
                }else{
                    false
                }
            }
        })

        viewModel.getMoviesTopRated()
        viewModel.getMoviesNowPlaying()
        showInfoRecyclerView()

        viewModel.movies.observe(viewLifecycleOwner){
            if (it.isEmpty()){
                binding.tvTitleMovieTopRated.hide()
                binding.rvTopRatedMovies.hide()
            }else{
                binding.tvTitleMovieTopRated.show()
                binding.rvTopRatedMovies.show()
            }
        }

        viewModel.moviesNowPlaying.observe(viewLifecycleOwner){
            if (it.isEmpty()){
                binding.tvTitleNowPlaying.hide()
                binding.rvNowPlayigMovies.hide()
            }else{
                binding.tvTitleNowPlaying.show()
                binding.rvNowPlayigMovies.show()
            }
        }
    }

    private fun showInfoRecyclerView(){
        binding.rvTopRatedMovies.adapter = moviesTopRatedAdapter
        viewModel.movies.observe(viewLifecycleOwner){
            moviesTopRatedAdapter.submitList(it)
        }

        binding.rvNowPlayigMovies.adapter = moviesNowPlayingAdapter
        viewModel.moviesNowPlaying.observe(viewLifecycleOwner){
            moviesNowPlayingAdapter.submitList(it)
        }
    }

    private fun customActionBar(){
        (activity as AppCompatActivity).supportActionBar!!.title = ""

        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowCustomEnabled(true)
        val inflater: LayoutInflater = requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.appbar_logo, null)
        (activity as AppCompatActivity).supportActionBar?.customView = view

        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.search ->{
                        Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show()
                        return true
                    }
                }
                return false
            }

        }, viewLifecycleOwner)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}