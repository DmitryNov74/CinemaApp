package com.example.cinemaapp.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.R
import com.example.cinemaapp.databinding.ItemMovieBinding
import com.example.cinemaapp.model.Movie
import com.squareup.picasso.Picasso


class MoviesAdapter(
    private var moviesList: List<Movie>,
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bindData(movie)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(movie: Movie) {
            Picasso.get().load(movie.getPosterUrl())
                .placeholder(R.mipmap.ic_launcher).into(binding.picPlace)
            binding.movieName.text = movie.originalTitle
            binding.movieGenre.text
            binding.movieRaiting.text = movie.voteAverage.toString()
        }

    }
}