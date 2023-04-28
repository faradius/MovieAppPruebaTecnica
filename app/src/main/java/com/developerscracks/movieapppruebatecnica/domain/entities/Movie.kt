package com.developerscracks.movieapppruebatecnica.domain.entities

data class Movie(
    val id: Int,
    val poster_path: String,
    val backdrop_path: String,
    val title: String,
    val overview: String,
    val vote_average: Double
){
    val movieVote = String.format("%.1f", vote_average)
}