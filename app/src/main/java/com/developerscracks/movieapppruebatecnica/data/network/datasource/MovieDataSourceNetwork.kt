package com.developerscracks.movieapppruebatecnica.data.network.datasource

import com.developerscracks.movieapppruebatecnica.data.network.model.MovieResponse
import com.developerscracks.movieapppruebatecnica.data.utils.ApiResponse

interface MovieDataSourceNetwork {

    suspend fun getTopRatedMovies():ApiResponse<MovieResponse>
}