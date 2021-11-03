package com.example.cinemaapp


import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String



){
    fun getGenresStrings() :String{
        return ServiceBuilder.GENRE_URL + name

    }
}