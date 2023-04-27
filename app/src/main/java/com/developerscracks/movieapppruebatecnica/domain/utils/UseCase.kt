package com.developerscracks.movieapppruebatecnica.domain.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P): MovieResult<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(params).let {
                    MovieResult.Success(it)
                }
            }

        } catch (e: Exception) {
            MovieResult.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: P): R

}