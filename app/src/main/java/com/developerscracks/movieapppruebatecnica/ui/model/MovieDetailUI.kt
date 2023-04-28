package com.developerscracks.movieapppruebatecnica.ui.model

data class MovieDetailUI(
    val id: Int,
    val backdrop_path: String,
    val poster_path: String,
    val title: String,
    val overview: String,
    val vote_average: Float
)