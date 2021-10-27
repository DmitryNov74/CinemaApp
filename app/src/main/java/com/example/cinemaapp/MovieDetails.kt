package com.example.cinemaapp


import com.google.gson.annotations.SerializedName

data class MovieDetails(

    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,

)