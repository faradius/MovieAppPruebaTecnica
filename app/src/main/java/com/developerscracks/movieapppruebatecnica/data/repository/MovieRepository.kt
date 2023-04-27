package com.developerscracks.movieapppruebatecnica.data.repository

import com.developerscracks.movieapppruebatecnica.domain.entities.Movie

interface MovieRepository {
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getMovieDetail(id: Int): Movie
}