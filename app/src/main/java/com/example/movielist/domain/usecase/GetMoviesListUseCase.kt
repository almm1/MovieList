package com.example.movielist.domain.usecase

import androidx.paging.PagingData
import com.example.movielist.domain.entity.Movies
import com.example.movielist.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    fun execute(): Flow<PagingData<Movies>> {
        return movieRepository.get()
    }
}