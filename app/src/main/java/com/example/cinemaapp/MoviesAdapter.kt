package com.example.cinemaapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.databinding.ItemMovieBinding


class MoviesAdapter(
    private val moviesList:MutableList<Moviee>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MovieViewHolder {

        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MovieViewHolder, position: Int) {
        with(holder){
            with(moviesList[position]){

            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}