package com.developerscracks.movieapppruebatecnica.data.repository

import android.util.Log
import com.developerscracks.movieapppruebatecnica.data.local.datasource.MovieLocalDataSource
import com.developerscracks.movieapppruebatecnica.data.mapper.dto.toDomain
import com.developerscracks.movieapppruebatecnica.data.mapper.toDomain
import com.developerscracks.movieapppruebatecnica.data.mapper.toEntity
import com.developerscracks.movieapppruebatecnica.data.network.datasource.MovieDataSourceNetwork
import com.developerscracks.movieapppruebatecnica.data.utils.ApiResponse
import com.developerscracks.movieapppruebatecnica.domain.entities.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val networkDatasource: MovieDataSourceNetwork,
    private val localDatasource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getTopRatedMovies(): List<Movie> {
        syncMovies()
        return localDatasource.getAllMovies().map { it.toDomain() }
    }

    override suspend fun getMovieDetail(id:Int): Movie {
        return localDatasource.getMovieById(id).toDomain()
    }

    private suspend fun syncMovies(){
        try {
            when(val response = networkDatasource.getTopRatedMovies()){
                is ApiResponse.ApiSuccessResponse ->{
                    val moviesNetwork = response.body.results.map { it.toEntity() }
                    localDatasource.insertAllMovies(moviesNetwork)
                }else ->{
                Log.i("Network Error", "No se guardaron los datos", )
                }
            }
        }catch (e: Exception){
            Log.e("Unknown error", "No se guardaron los datos")
        }
    }
}