package com.developerscracks.movieapppruebatecnica.di

import com.developerscracks.movieapppruebatecnica.data.repository.MovieRepository
import com.developerscracks.movieapppruebatecnica.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun providesMoviesUseCases(repository: MovieRepository, @IoDispatcher dispatcher: CoroutineDispatcher) = MovieUseCases(
        getMovieTopRatedUseCase = GetMovieTopRatedUseCase(repository, dispatcher),
        getMovieDetailUseCase = GetMovieDetailUseCase(repository, dispatcher),
        getMovieByTitleUseCase = GetMovieByTitleUseCase(repository, dispatcher),
        getMovieNowPlayingUseCase = GetMovieNowPlayingUseCase(repository, dispatcher)
    )
}