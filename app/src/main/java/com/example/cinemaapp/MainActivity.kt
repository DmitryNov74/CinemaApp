package com.example.cinemaapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaapp.ServiceBuilder.buildService
import com.example.cinemaapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var url = "https://api.themoviedb.org/3/movie/upcoming?api_key="
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // loadPics()
        loadMovies()
        moviesAdapter = MoviesAdapter(emptyList())



        binding.comingSoon.adapter = moviesAdapter
        binding.comingSoon.layoutManager = LinearLayoutManager(this)


    }

    //private fun loadPics(){
    //  movieList = listOf(
    //    Moviee("qqq"),
    //  Moviee("www"),
    //Moviee("eee"),
    //Moviee("ttt"),
    //Moviee("uuu"),
    //Moviee("eee"),
    //Moviee("fff"),
    //Moviee("mmm"),
    //Moviee("nnn"),
    // Moviee(",,,"),
    //Moviee("zzz"),
    //Moviee("ååå"),

    //)
    //}

    private fun loadMovies() {

        val movieService = buildService(MovieDbInterface::class.java)
        val requestCall = movieService.getMovieDetails()

        requestCall.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {

                if (response.isSuccessful && response.body() != null) {
                    val movieDetails = response.body()!!

                    binding.comingSoon.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity, 2)
                        adapter = MoviesAdapter(movieDetails.results)
                    }
                } else {
                    Log.e("MainActivity", "Error fetching movies: ${response.errorBody().toString()}")
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