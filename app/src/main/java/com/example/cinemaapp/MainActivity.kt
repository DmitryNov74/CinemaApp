package com.example.cinemaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var url = "https://api.themoviedb.org/3/movie/550?api_key="
    private lateinit var moviesAdapter:MoviesAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieList :List<Moviee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadPics()

        moviesAdapter = MoviesAdapter(movieList)



        binding.comingSoon.adapter = moviesAdapter
        binding.comingSoon.layoutManager = LinearLayoutManager(this)
    }

    private fun loadPics(){
        movieList = listOf(
            Moviee("qqq"),
            Moviee("www"),
            Moviee("eee"),
            Moviee("ttt"),
            Moviee("uuu"),
            Moviee("eee"),
            Moviee("fff"),
            Moviee("mmm"),
            Moviee("nnn"),
            Moviee(",,,"),
            Moviee("zzz"),
            Moviee("ååå"),

            )
    }
}