package com.example.cinemaapp


import com.google.gson.annotations.SerializedName

data class GenresOfMovies(
    @SerializedName("genres")
    val genres: List<Genre>
)