package com.my.movie.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.movie.db.data.MoviesRepository
import com.my.movie.db.data.Resource
import com.my.movie.db.data.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
	private val repository: MoviesRepository
) : ViewModel() {
	private val _movies = MutableStateFlow<Resource<List<Movie>>?>(null)

	val movies: StateFlow<Resource<List<Movie>>?> = _movies

	init {
		viewModelScope.launch {
			_movies.value = Resource.Loading
			_movies.value = repository.getPopularMovies()
		}
	}
}