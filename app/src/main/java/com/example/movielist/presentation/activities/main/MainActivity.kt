package com.example.movielist.presentation.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.movielist.App
import com.example.movielist.databinding.MainActivityBinding
import com.example.movielist.presentation.adapter.MovieListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var adapter: MovieListAdapter
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var vmFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as App).appComponent.injectMainActivity(this)

        initAdapter()
        initViewModel()
        setupList()
    }

    private fun initAdapter() {
        adapter = MovieListAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)
    }

    private fun setupList() {
        lifecycleScope.launch {
            viewModel.movies?.collectLatest { pagedData ->
                adapter.submitData(pagedData)
            }
        }
    }
}