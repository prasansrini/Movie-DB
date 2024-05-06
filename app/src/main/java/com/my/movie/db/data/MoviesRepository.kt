package com.my.movie.db.data

import com.my.movie.db.data.model.Movie

interface MoviesRepository {
	suspend fun getPopularMovies(): Resource<List<Movie>>
}