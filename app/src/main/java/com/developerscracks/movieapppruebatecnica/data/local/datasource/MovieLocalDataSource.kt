package com.developerscracks.movieapppruebatecnica.data.local.datasource

import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity

interface MovieLocalDataSource {

    suspend fun getAllMovies(): List<MovieEntity>

    suspend fun getMovieById(id:Int): MovieEntity

    suspend fun getMoviesByTitle(query: String): List<MovieEntity>

    suspend fun insertAllMovies(movies: List<MovieEntity>)

    suspend fun deleteAllMovies(movies: List<MovieEntity>)
}