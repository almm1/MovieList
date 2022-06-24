package com.example.movielist.data.datasourse

import com.example.movielist.BuildConfig
import com.example.movielist.data.api.MoviesApi
import com.example.movielist.data.mappers.ApiResponseMapper
import com.example.movielist.domain.entity.Movies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataSource @Inject constructor(
    private val service: MoviesApi,
    private val mapper: ApiResponseMapper
) {

    suspend fun getMovies(page: Int): Flow<List<Movies>> =
        flow {
            val response = service.getMovies(page, BuildConfig.API_KEY)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val result = mapper.toEntityData(body)
                    emit(result)
                }
            }
        }
}