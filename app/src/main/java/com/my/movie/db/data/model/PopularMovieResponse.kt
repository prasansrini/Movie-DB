package com.my.movie.db.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
	@SerialName("page") val page: Int, @SerialName("results") val movies: List<Movie>,
	@SerialName("total_pages") val totalPages: Int,
	@SerialName("total_results") val totalResults: Int
)