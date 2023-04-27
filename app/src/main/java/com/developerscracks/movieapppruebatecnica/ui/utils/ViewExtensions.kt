package com.developerscracks.movieapppruebatecnica.ui.utils

import com.developerscracks.movieapppruebatecnica.core.Config.IMAGE_URL_BASE

fun String.toMovieUrl(): String {
    return "$IMAGE_URL_BASE$this"
}