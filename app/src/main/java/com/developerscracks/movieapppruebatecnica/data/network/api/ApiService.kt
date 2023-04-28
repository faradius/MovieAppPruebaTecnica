package com.developerscracks.movieapppruebatecnica.data.network.api

import com.developerscracks.movieapppruebatecnica.data.network.model.movie.MovieResponse
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query ("api_key") apiKey:String): Response<MovieResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query ("api_key") apiKey: String): Response<MovieResponse>

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: String, @Query ("api_key") apiKey: String): Response<MovieDetailDTO>
}