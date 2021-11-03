package com.example.cinemaapp.data.network

import com.example.cinemaapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    //"https://api.themoviedb.org/3/genre/movie/list?api_key=39c7fb0822b42e228245de1f7c8d5a48&language=en-US
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    const val GENRE_URL = "https://api.themoviedb.org/3/genre/movie/list"
    const val API_KEY = "39c7fb0822b42e228245de1f7c8d5a48"


    private val logging = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()



    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

