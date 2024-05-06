package com.my.movie.db.di

import com.my.movie.db.data.MoviesRepository
import com.my.movie.db.data.MoviesRepositoryImpl
import com.my.movie.db.data.network.TmDbHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
	@Provides
	@Singleton
	fun getHttpClient(httpClient: TmDbHttpClient) = httpClient.getHttpClient()

	@Provides
	@Singleton
	fun getMoviesRepository(repoImpl: MoviesRepositoryImpl): MoviesRepository = repoImpl
}