package com.developerscracks.movieapppruebatecnica.data.local.dao

import androidx.room.*
import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id:Int): MovieEntity

    @Query("SELECT * FROM movies WHERE title LIKE '%' || :query || '%'")
    suspend fun getMovieByTitle(query: String): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Delete
    suspend fun deleteMovies(movies: List<MovieEntity>)
}