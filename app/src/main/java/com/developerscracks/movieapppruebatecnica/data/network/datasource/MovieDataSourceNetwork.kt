package com.developerscracks.movieapppruebatecnica.data.network.datasource

import com.developerscracks.movieapppruebatecnica.data.network.model.movie.MovieResponse
import com.developerscracks.movieapppruebatecnica.data.utils.ApiResponse
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO

interface MovieDataSourceNetwork {

    suspend fun getTopRatedMovies():ApiResponse<MovieResponse>
    suspend fun getNowPlayingMovies():ApiResponse<MovieResponse>
    suspend fun getMovieDetail(id:String): ApiResponse<MovieDetailDTO>
}