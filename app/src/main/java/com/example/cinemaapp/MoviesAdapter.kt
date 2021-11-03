package com.example.cinemaapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso


class MoviesAdapter(

    private var moviesList: List<Result>,
   // private val genreList:List<Genre>

    ) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = moviesList[position]
       // val genre = genreList[position]

        holder.bindData(movie)

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(movie: Result) {
            Picasso.get().load(movie.getPosterUrl())
                .placeholder(R.mipmap.ic_launcher).into(binding.picPlace)
            binding.movieName.text = movie.originalTitle
            binding.movieGenre.text
            binding.movieRaiting.text = movie.voteAverage.toString()
        }

    }
}