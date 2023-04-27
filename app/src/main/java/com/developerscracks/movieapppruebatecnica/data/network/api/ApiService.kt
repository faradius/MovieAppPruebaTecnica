package com.developerscracks.movieapppruebatecnica.data.network.api

import com.developerscracks.movieapppruebatecnica.data.network.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query ("api_key") apiKey:String): Response<MovieResponse>
}