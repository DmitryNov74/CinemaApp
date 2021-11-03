package com.example.cinemaapp.data.network

import com.example.cinemaapp.model.GenreResponse
import com.example.cinemaapp.model.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbInterface {

    //https://api.themoviedb.org/3/movie/550?api_key=
    //https://api.themoviedb.org/3/movie/upcoming?api_key=
    //https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getMovieDetails(
        @Query("api_key") apiKey: String = ServiceBuilder.API_KEY
    ): Call<MovieDetails>

    @GET("genre/movie/list")
    fun getGenresDetails(
        @Query("api_key") apiKey: String = ServiceBuilder.API_KEY
    ): Call<GenreResponse>

}