package com.developerscracks.movieapppruebatecnica.data.repository

import com.developerscracks.movieapppruebatecnica.data.mapper.dto.toDomain
import com.developerscracks.movieapppruebatecnica.data.network.datasource.MovieDataSourceNetwork
import com.developerscracks.movieapppruebatecnica.data.utils.ApiResponse
import com.developerscracks.movieapppruebatecnica.domain.entities.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val networkDatasource: MovieDataSourceNetwork
) : MovieRepository {
    override suspend fun getTopRatedMovies(): List<Movie> {
        return when (val response = networkDatasource.getTopRatedMovies()) {
            is ApiResponse.ApiEmptyResponse -> throw NotImplementedError("Implement a strategy when the response is empty")
            is ApiResponse.ApiError -> throw NotImplementedError("Implemented estrategy when the api rest throw a error")
            is ApiResponse.ApiSuccessResponse -> {
                response.body.results.map {
                    it.toDomain()
                }
            }
        }
    }
}