package com.developerscracks.movieapppruebatecnica.ui.mapper

import com.developerscracks.movieapppruebatecnica.domain.entities.Movie
import com.developerscracks.movieapppruebatecnica.ui.model.MovieUI
import com.developerscracks.movieapppruebatecnica.ui.utils.toMovieUrl

fun Movie.toMovieUI(): MovieUI{
    return MovieUI(
        id = id,
        poster_path = this.poster_path.toMovieUrl(),
        title = title,
        vote_average = vote_average
    )
}