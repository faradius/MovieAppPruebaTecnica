package com.developerscracks.movieapppruebatecnica.data.mapper.dto

import com.developerscracks.movieapppruebatecnica.data.network.model.MovieDTO
import com.developerscracks.movieapppruebatecnica.domain.entities.Movie

fun MovieDTO.toDomain(): Movie{
    return Movie(
        id = id,
        poster_path= poster_path,
        backdrop_path = backdrop_path,
        title = title,
        overview = overview,
        vote_average = vote_average
    )
}