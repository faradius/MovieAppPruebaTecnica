package com.developerscracks.movieapppruebatecnica.data.network.model

data class MovieResponse(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)