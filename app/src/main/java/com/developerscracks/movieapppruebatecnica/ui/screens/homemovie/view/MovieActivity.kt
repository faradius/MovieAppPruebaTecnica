package com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developerscracks.movieapppruebatecnica.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
    }
}