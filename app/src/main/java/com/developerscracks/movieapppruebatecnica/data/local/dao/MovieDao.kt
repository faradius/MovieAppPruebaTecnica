package com.developerscracks.movieapppruebatecnica.data.local.dao

import androidx.room.*
import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE category = :category")
    suspend fun getMoviesTopRated(category:String): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE category = :category")
    suspend fun getMoviesNowPlaying(category:String): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id:Int): MovieEntity

    @Query("SELECT * FROM movies WHERE title LIKE '%' || :query || '%' AND category = 'top_rated'")
    suspend fun getMovieByTitle(query: String): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE title LIKE '%' || :query || '%' AND category = 'now_playing'")
    suspend fun getMovieByTitleNowPlaying(query: String): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Delete
    suspend fun deleteMovies(movies: List<MovieEntity>)
}