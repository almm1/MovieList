package com.example.movielist.data.mappers

import com.example.movielist.data.api.ResponseApi
import com.example.movielist.domain.entity.Movies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiResponseMapper @Inject constructor() {
    fun toEntityData(response: ResponseApi): List<Movies> {
        return (
                response.results.map {
                    Movies(
                        it.displayTitle,
                        it.summaryShort,
                        it.multimedia.src
                    )
                })
    }
}