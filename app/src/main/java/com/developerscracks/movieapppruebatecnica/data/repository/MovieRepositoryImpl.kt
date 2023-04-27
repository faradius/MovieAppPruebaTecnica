package com.developerscracks.movieapppruebatecnica.data.repository

import android.util.Log
import com.developerscracks.movieapppruebatecnica.data.local.datasource.MovieLocalDataSource
import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity
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
        syncMoviesTopRated()
        return localDatasource.getMoviesTopRated("top_rated").map { it.toDomain() }
    }

    override suspend fun getPlayingMovies(): List<Movie> {
        syncPlayingNow()
        return localDatasource.getMoviesNowPlaying("now_playing").map { it.toDomain() }
    }

    override suspend fun getMovieByTitle(query: String): List<Movie> {
        return localDatasource.getMoviesByTitle(query).map { it.toDomain() }
    }

    override suspend fun getMovieDetail(id:Int): Movie {
        return localDatasource.getMovieById(id).toDomain()
    }

    private suspend fun syncMoviesTopRated(){
        try {
            when(val response = networkDatasource.getTopRatedMovies()){
                is ApiResponse.ApiSuccessResponse ->{
                    val moviesNetwork = response.body.results.map { movie->
                        movie.toEntity().copy(category = "top_rated")
                    }
                    localDatasource.insertAllMovies(moviesNetwork)
                }else ->{
                Log.i("Network Error", "No se guardaron los datos", )
                }
            }
        }catch (e: Exception){
            Log.e("Unknown error", "No se guardaron los datos")
        }
    }

    private suspend fun syncPlayingNow(){
        try {
            when(val response = networkDatasource.getNowPlayingMovies()){
                is ApiResponse.ApiSuccessResponse ->{
                    val moviesNetwork = response.body.results.map { movie->
                        movie.toEntity().copy(category = "now_playing")
                    }
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