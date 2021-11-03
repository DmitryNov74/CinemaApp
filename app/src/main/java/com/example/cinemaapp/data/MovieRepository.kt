package com.example.cinemaapp.data

import com.example.cinemaapp.data.network.MovieApiInterface
import com.example.cinemaapp.data.network.ServiceBuilder

/**
 * Created by Vipul Asri on 03/11/21.
 */

object MovieRepository {

    val movieService = ServiceBuilder.buildService(MovieApiInterface::class.java)

    fun getMovieDetails() = movieService.getMovieDetails()
    fun getGenres() = movieService.getGenres()
}