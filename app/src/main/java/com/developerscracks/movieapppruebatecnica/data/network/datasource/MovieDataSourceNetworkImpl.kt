package com.developerscracks.movieapppruebatecnica.data.network.datasource

import com.developerscracks.movieapppruebatecnica.core.Config.API_KEY
import com.developerscracks.movieapppruebatecnica.data.network.api.ApiService
import com.developerscracks.movieapppruebatecnica.data.network.model.movie.MovieResponse
import com.developerscracks.movieapppruebatecnica.data.utils.ApiResponse
import com.developerscracks.movieapppruebatecnica.data.utils.handleResponse
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import javax.inject.Inject

class MovieDataSourceNetworkImpl @Inject constructor(private val api: ApiService): MovieDataSourceNetwork {
    override suspend fun getTopRatedMovies(): ApiResponse<MovieResponse> {
        return api.getTopRatedMovies(API_KEY).handleResponse()
    }

    override suspend fun getMovieDetail(id: String): ApiResponse<MovieDetailDTO> {
        return api.getMovieDetail(id, API_KEY).handleResponse()
    }
}