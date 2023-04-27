package com.developerscracks.movieapppruebatecnica.ui.mapper

import com.developerscracks.movieapppruebatecnica.domain.entities.Movie
import com.developerscracks.movieapppruebatecnica.ui.model.MovieDetailUI
import com.developerscracks.movieapppruebatecnica.ui.utils.toMovieUrl

fun Movie.toMovieDetailUI(): MovieDetailUI {
    return MovieDetailUI(
        id = id,
        backdrop_path = backdrop_path.toMovieUrl(),
        poster_path = poster_path.toMovieUrl(),
        title = title,
        overview = overview,
        vote_average = this.movieVote.toFloat()
    )
}