package com.developerscracks.movieapppruebatecnica.data.network.datasource

import com.developerscracks.movieapppruebatecnica.core.Config.API_KEY
import com.developerscracks.movieapppruebatecnica.data.network.api.ApiService
import com.developerscracks.movieapppruebatecnica.data.network.model.MovieResponse
import com.developerscracks.movieapppruebatecnica.data.utils.ApiResponse
import com.developerscracks.movieapppruebatecnica.data.utils.handleResponse
import javax.inject.Inject

class MovieDataSourceNetworkImpl @Inject constructor(private val api: ApiService): MovieDataSourceNetwork {
    override suspend fun getTopRatedMovies(): ApiResponse<MovieResponse> {
        return api.getTopRatedMovies(API_KEY).handleResponse()
    }
}