package com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.developerscracks.movieapppruebatecnica.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        /*supportActionBar?.setDisplayShowCustomEnabled(true)
        val inflater: LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.appbar_logo, null)
        supportActionBar?.customView = view*/
    }
}