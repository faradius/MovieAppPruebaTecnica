package com.developerscracks.movieapppruebatecnica.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.developerscracks.movieapppruebatecnica.data.local.dao.MovieDao
import com.developerscracks.movieapppruebatecnica.data.local.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}