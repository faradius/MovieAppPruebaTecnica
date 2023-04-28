package com.developerscracks.movieapppruebatecnica.di

import android.content.Context
import androidx.room.Room
import com.developerscracks.movieapppruebatecnica.core.Config.DB_NAME
import com.developerscracks.movieapppruebatecnica.data.local.dao.MovieDao
import com.developerscracks.movieapppruebatecnica.data.local.db.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun providesMovieDatabase(@ApplicationContext context: Context): MovieDataBase{
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesMovieDao(dataBase: MovieDataBase): MovieDao{
        return dataBase.movieDao()
    }

}