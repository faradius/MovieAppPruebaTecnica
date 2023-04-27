package com.developerscracks.movieapppruebatecnica.di

import com.developerscracks.movieapppruebatecnica.data.network.datasource.MovieDataSourceNetwork
import com.developerscracks.movieapppruebatecnica.data.network.datasource.MovieDataSourceNetworkImpl
import com.developerscracks.movieapppruebatecnica.data.repository.MovieRepository
import com.developerscracks.movieapppruebatecnica.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieModule {
    @Binds
    abstract fun bindsMovieDataSourceNetwork(impl: MovieDataSourceNetworkImpl): MovieDataSourceNetwork

    @Binds
    abstract fun bindsMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}