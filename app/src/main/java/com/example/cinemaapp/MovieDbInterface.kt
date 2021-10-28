package com.example.cinemaapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface MovieDbInterface {

    //https://api.themoviedb.org/3/movie/550?api_key=
    //https://api.themoviedb.org/3/movie/upcoming?api_key=
    //https://api.themoviedb.org/3/

    @GET("/movie/popular")
    fun getMovieDetails():Call<MovieDetails>
        //@Query("api_key") apiKey :String = "",
       // @Query("page") page:Int):Call<MovieDetails>
}