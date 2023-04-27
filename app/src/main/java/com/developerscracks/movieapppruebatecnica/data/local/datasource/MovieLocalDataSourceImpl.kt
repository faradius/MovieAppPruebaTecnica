package com.developerscracks.movieapppruebatecnica.data.local.datasource

import com.developerscracks.movieapppruebatecnica.data.local.dao.MovieDao
import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
): MovieLocalDataSource{
    override suspend fun getAllMovies(): List<MovieEntity> = movieDao.getAllMovies()

    override suspend fun getMovieById(id: Int): MovieEntity = movieDao.getMovieById(id)

    override suspend fun insertAllMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)

    override suspend fun deleteAllMovies(movies: List<MovieEntity>) = movieDao.deleteMovies(movies)
}