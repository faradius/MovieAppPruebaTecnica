package com.developerscracks.movieapppruebatecnica.ui.screens.detailmovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerscracks.movieapppruebatecnica.domain.usecase.MovieUseCases
import com.developerscracks.movieapppruebatecnica.domain.utils.MovieResult
import com.developerscracks.movieapppruebatecnica.ui.mapper.toMovieDetailUI
import com.developerscracks.movieapppruebatecnica.ui.mapper.toMovieUI
import com.developerscracks.movieapppruebatecnica.ui.model.MovieDetailUI
import com.developerscracks.movieapppruebatecnica.ui.model.MovieUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val movieUseCases: MovieUseCases):ViewModel() {
    private val _movie: MutableLiveData<MovieDetailUI> = MutableLiveData()
    val movie: LiveData<MovieDetailUI> = _movie

    private var _mensaje = MutableLiveData<String>()
    val mensaje:LiveData<String> = _mensaje

    fun getMovieDetail(id: Int){
        viewModelScope.launch {
            val result = movieUseCases.getMovieDetailUseCase(id)
            when(result){
                is MovieResult.Error ->{
                    _mensaje.value = result.error.message ?: "Error desconocido"
                }

                is MovieResult.Success ->{
                    _movie.value = result.data.toMovieDetailUI()
                }
            }
        }
    }
}