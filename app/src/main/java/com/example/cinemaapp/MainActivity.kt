package com.example.cinemaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cinemaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var url = "https://api.themoviedb.org/3/movie/550?api_key="
    private lateinit var moviesAdapter:MoviesAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}