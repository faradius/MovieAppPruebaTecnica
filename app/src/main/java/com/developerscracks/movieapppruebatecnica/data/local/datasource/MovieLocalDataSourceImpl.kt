package com.developerscracks.movieapppruebatecnica.data.local.datasource

import com.developerscracks.movieapppruebatecnica.data.local.dao.MovieDao
import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
): MovieLocalDataSource{
    override suspend fun getMoviesTopRated(category: String): List<MovieEntity> = movieDao.getMoviesTopRated(category)
    override suspend fun getMoviesNowPlaying(category: String): List<MovieEntity> =movieDao.getMoviesNowPlaying(category)

    override suspend fun getMovieById(id: Int): MovieEntity = movieDao.getMovieById(id)
    override suspend fun getMoviesByTitle(query: String): List<MovieEntity> = movieDao.getMovieByTitle(query)
    override suspend fun getMoviesByTitleNowPlaying(query: String): List<MovieEntity> = movieDao.getMovieByTitleNowPlaying(query)

    override suspend fun insertAllMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)

    override suspend fun deleteAllMovies(movies: List<MovieEntity>) = movieDao.deleteMovies(movies)
}