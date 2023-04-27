package com.developerscracks.movieapppruebatecnica.domain.utils

sealed class MovieResult<out R> {
    data class Success<T>(val data: T) : MovieResult<T>()
    data class Error(val error: Exception) : MovieResult<Nothing>()
}
