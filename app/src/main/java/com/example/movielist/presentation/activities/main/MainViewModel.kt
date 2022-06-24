package com.example.movielist.presentation.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movielist.domain.entity.Movies
import com.example.movielist.domain.usecase.GetMoviesListUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getMoviesListUseCase: GetMoviesListUseCase
) : ViewModel() {

    var movies: Flow<PagingData<Movies>>? =null
    init {
         movies = getMoviesListUseCase.execute().cachedIn(viewModelScope)
    }
}
class ViewModelFactory @Inject constructor(private val getMoviesListUseCase: GetMoviesListUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getMoviesListUseCase
        ) as T
    }
}