package com.developerscracks.movieapppruebatecnica.domain.usecase

data class MovieUseCases (
    val getMovieTopRatedUseCase: GetMovieTopRatedUseCase,
    val getMovieDetailUseCase: GetMovieDetailUseCase,
    val getMovieByTitleUseCase: GetMovieByTitleUseCase,
    val getMovieNowPlayingUseCase: GetMovieNowPlayingUseCase,
    val getMovieByTitleNowPlayingUseCase: GetMovieByTitleNowPlayingUseCase
)