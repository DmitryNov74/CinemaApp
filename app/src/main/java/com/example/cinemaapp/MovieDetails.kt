package com.example.cinemaapp


import com.google.gson.annotations.SerializedName

// API MODEL

data class MovieDetails(

    @SerializedName("page")
    val page: String,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,

    )