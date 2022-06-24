package com.example.movielist.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("all.json")
   suspend fun getMovies(
        @Query("offset") offset: Int,
        @Query("api-key") apiKey: String
    ): Response<ResponseApi>
}