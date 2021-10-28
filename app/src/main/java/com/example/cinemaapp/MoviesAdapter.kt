package com.example.cinemaapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso


class MoviesAdapter(
    private var moviesList: List<Result>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding = binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var curPic = moviesList[position]
        Picasso.get().load("https://api.themoviedb.org/")
            .placeholder(R.mipmap.ic_launcher).into(holder.binding.picPlace)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}