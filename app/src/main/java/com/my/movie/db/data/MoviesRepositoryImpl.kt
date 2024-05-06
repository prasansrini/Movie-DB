package com.my.movie.db.data

import com.my.movie.db.data.model.Movie
import com.my.movie.db.data.model.PopularMovieResponse
import com.my.movie.db.data.network.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

private const val POPULAR_MOVIES = "${BASE_URL}/popular"

class MoviesRepositoryImpl(
	private val httpClient: HttpClient
) : MoviesRepository {
	override suspend fun getPopularMovies(): Resource<List<Movie>> {
		return try {
			Resource.Success(
				httpClient.get<PopularMovieResponse> {
					url(POPULAR_MOVIES)
				}.movies
			)
		} catch (e: Exception) {
			e.printStackTrace()
			Resource.Failure(e)
		}
	}
}