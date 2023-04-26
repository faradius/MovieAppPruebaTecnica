package com.developerscracks.movieapppruebatecnica.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.developerscracks.movieapppruebatecnica.R
import com.developerscracks.movieapppruebatecnica.ui.homemovie.MovieActivity
import com.developerscracks.movieapppruebatecnica.ui.utils.Constants.DURACION_SPLASH_SCREEN


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        changeScreen()
    }

    private fun changeScreen(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
            finish()
        }, DURACION_SPLASH_SCREEN)
    }
}