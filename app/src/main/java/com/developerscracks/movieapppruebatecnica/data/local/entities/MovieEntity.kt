package com.developerscracks.movieapppruebatecnica.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "poster_path" )val posterPath: String?,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "overview" ) val overview: String?,
    @ColumnInfo(name = "vote_average") val voteAverage: Double?
)