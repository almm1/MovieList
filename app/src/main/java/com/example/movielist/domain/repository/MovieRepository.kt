package com.example.movielist.domain.repository

import androidx.paging.PagingData
import com.example.movielist.domain.entity.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun get(): Flow<PagingData<Movies>>
}