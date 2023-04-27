package com.developerscracks.movieapppruebatecnica.data.mapper

import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity
import com.developerscracks.movieapppruebatecnica.data.network.model.movie.MovieDTO
import com.developerscracks.movieapppruebatecnica.domain.entities.Movie

fun MovieEntity.toDomain(): Movie{
    return Movie(
        id = id,
        backdrop_path = backdropPath.orEmpty(),
        poster_path = posterPath.orEmpty(),
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        vote_average = (voteAverage ?: 0) as Double
    )
}

fun MovieDTO.toEntity(): MovieEntity{
    return MovieEntity(
        id = id,
        posterPath = poster_path,
        backdropPath = backdrop_path,
        title = title,
        overview = overview,
        voteAverage = vote_average,
        category = ""
    )
}