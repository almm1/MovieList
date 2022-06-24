package com.example.movielist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.movielist.data.datasourse.MovieDataSource
import com.example.movielist.data.datasourse.PageSource
import com.example.movielist.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val dataSource: MovieDataSource) :
    MovieRepository {
    override fun get() = Pager(
        config = PagingConfig(
            PAGE_SIZE, initialLoadSize = INIT_LOAD_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            PageSource(dataSource)
        }).flow

    companion object {
        private const val PAGE_SIZE = 10
        private const val INIT_LOAD_SIZE = PAGE_SIZE * 3
    }
}