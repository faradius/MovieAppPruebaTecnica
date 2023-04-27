package com.developerscracks.movieapppruebatecnica.ui.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.developerscracks.movieapppruebatecnica.core.Config.IMAGE_URL_BASE

fun String.toMovieUrl(): String {
    return "$IMAGE_URL_BASE$this"
}

fun View.hideKeyboard(){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
    this.clearFocus()
}