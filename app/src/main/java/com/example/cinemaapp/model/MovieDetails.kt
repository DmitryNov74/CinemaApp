package com.example.cinemaapp.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("page")
    val page: String,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
)