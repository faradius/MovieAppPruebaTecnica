package com.developerscracks.movieapppruebatecnica.domain.usecase

import com.developerscracks.movieapppruebatecnica.data.repository.MovieRepository
import com.developerscracks.movieapppruebatecnica.di.IoDispatcher
import com.developerscracks.movieapppruebatecnica.domain.entities.Movie
import com.developerscracks.movieapppruebatecnica.domain.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMovieTopRatedUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): UseCase<Unit, List<Movie>>(dispatcher) {
    override suspend fun execute(params: Unit): List<Movie> {
        return movieRepository.getTopRatedMovies()
    }
}