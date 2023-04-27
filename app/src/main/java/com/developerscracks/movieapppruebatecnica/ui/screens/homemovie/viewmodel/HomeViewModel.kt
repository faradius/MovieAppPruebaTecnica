package com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerscracks.movieapppruebatecnica.domain.usecase.MovieUseCases
import com.developerscracks.movieapppruebatecnica.domain.utils.MovieResult
import com.developerscracks.movieapppruebatecnica.ui.mapper.toMovieUI
import com.developerscracks.movieapppruebatecnica.ui.model.MovieUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieUseCases: MovieUseCases): ViewModel() {
    private val _movies: MutableLiveData<List<MovieUI>> = MutableLiveData()
    val movies: LiveData<List<MovieUI>> = _movies

    private val _moviesNowPlaying: MutableLiveData<List<MovieUI>> = MutableLiveData()
    val moviesNowPlaying: LiveData<List<MovieUI>> = _moviesNowPlaying

    private var _mensaje = MutableLiveData<String>()
    val mensaje:LiveData<String> = _mensaje

    fun getMoviesTopRated(){
        viewModelScope.launch {
            val result = movieUseCases.getMovieTopRatedUseCase(Unit)
            when (result){
                is MovieResult.Error -> {
                    _mensaje.value = result.error.message ?: "Error desconocido"
                }
                is MovieResult.Success ->{
                    _movies.value = result.data.map { it.toMovieUI() }
                }
            }
        }
    }

    fun getMoviesNowPlaying(){
        viewModelScope.launch {
            val result = movieUseCases.getMovieNowPlayingUseCase(Unit)
            when (result){
                is MovieResult.Error -> {
                    _mensaje.value = result.error.message ?: "Error desconocido"
                }
                is MovieResult.Success ->{
                    _moviesNowPlaying.value = result.data.map { it.toMovieUI() }
                }
            }
        }
    }

    fun getMovieByTitle(query: String){
        viewModelScope.launch {
            val result = movieUseCases.getMovieByTitleUseCase(query)
            when (result){
                is MovieResult.Error -> {
                    _mensaje.value = result.error.message ?: "Error desconocido"
                }
                is MovieResult.Success ->{
                    _movies.value = result.data.map { it.toMovieUI() }
                    _moviesNowPlaying.value = result.data.map { it.toMovieUI() }
                }
            }
        }
    }
}