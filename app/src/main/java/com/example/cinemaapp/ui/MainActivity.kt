package com.example.cinemaapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaapp.data.MovieRepository
import com.example.cinemaapp.databinding.ActivityMainBinding
import com.example.cinemaapp.model.Genre
import com.example.cinemaapp.model.GenreResponse
import com.example.cinemaapp.model.MovieDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadData()
        moviesAdapter = MoviesAdapter(emptyList(), emptyList())

        binding.comingSoon.adapter = moviesAdapter
        binding.comingSoon.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() {
        // load genres first
        loadGenres { genres ->
            // load movies now
            loadMovies(genres)
        }
    }

    private fun loadGenres(onResult: (List<Genre>) -> Unit) {
        MovieRepository.getGenres().enqueue(object : Callback<GenreResponse> {
            override fun onResponse(call: Call<GenreResponse>, response: Response<GenreResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val genresResponse = response.body()!!
                    onResult.invoke(genresResponse.genres)
                } else {
                    onResult.invoke(emptyList())
                }
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                onResult.invoke(emptyList())
            }
        })
    }

    private fun loadMovies(genres: List<Genre>) {
        MovieRepository.getMovieDetails().enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {

                if (response.isSuccessful && response.body() != null) {
                    val movieDetails = response.body()!!

                    binding.comingSoon.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = MoviesAdapter(genres, movieDetails.results)
                        Log.d("json", "onGoing" + movieDetails.results);
                    }
                } else {
                    Log.e(
                        "MainActivity",
                        "Error fetching movies: ${response.errorBody().toString()}"
                    )
                    Toast.makeText(
                        this@MainActivity,
                        "Something went wrong ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}