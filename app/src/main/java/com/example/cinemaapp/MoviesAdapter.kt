package com.example.cinemaapp


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso


class MoviesAdapter(
    private var moviesList: List<Result>,

) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


     class MovieViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding = binding
        var imageViewer :ImageView = binding.picPlace


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var curPic = moviesList[position]


        Picasso.get().load("https://api.themoviedb.org/3/")
            .placeholder(R.mipmap.ic_launcher).into(holder.imageViewer)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}
//