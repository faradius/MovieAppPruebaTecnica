package com.developerscracks.movieapppruebatecnica.ui.screens.homemovie.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developerscracks.movieapppruebatecnica.databinding.MovieItemBinding
import com.developerscracks.movieapppruebatecnica.ui.model.MovieUI

class MoviesTopRatedAdapter(
//    private val onClick: (Int) -> Unit
) : ListAdapter<MovieUI, MoviesTopRatedAdapter.MovieViewHolder>(MovieDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class MovieViewHolder(
        itemBinding: MovieItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private val title = itemBinding.tvTitleMovie
        private val posterPath = itemBinding.ivMovie
        private val voteAverage = itemBinding.tvVoteAverageMovie

        private var currentMovie: MovieUI? = null

        init {
            itemView.setOnClickListener {
                currentMovie?.let {
//                    onClick(it.id)
                }
            }
        }

        fun bind(movie: MovieUI) {
            currentMovie = movie

            title.text = movie.title
            voteAverage.text = "${movie.vote_average}/10"

            Glide.with(itemView.context)
                .load(movie.poster_path)
                .into(posterPath)

        }
    }
}

object MovieDiffUtil : DiffUtil.ItemCallback<MovieUI>() {
    override fun areItemsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean =
        oldItem == newItem

}