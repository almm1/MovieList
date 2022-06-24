package com.example.movielist.data.datasourse

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movielist.domain.entity.Movies
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PageSource @Inject constructor(private val dataSource: MovieDataSource) :
    PagingSource<Int, Movies>() {

    override fun getRefreshKey(state: PagingState<Int, Movies>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movies> {
        return try {
            val nextPageNumber = params.key ?: 0
            val movies = dataSource.getMovies(nextPageNumber).flatMapConcat { it.asFlow() }.toList()

            LoadResult.Page(
                data = movies,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < movies.size) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

