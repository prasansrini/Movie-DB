package com.my.movie.db

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.my.movie.db.data.Resource
import com.my.movie.db.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.my.movie.db.ui.movies.MovieList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val viewModel by viewModels<MovieViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {

			val context = LocalContext.current

			val movies = viewModel.movies.collectAsState()

			AppTheme {
				movies.value?.let {
					when (it) {
						is Resource.Failure -> {
							Toast
								.makeText(
									context,
									it.exception.message,
									Toast.LENGTH_SHORT
								)
								.show()
						}

						is Resource.Loading -> {
							Toast
								.makeText(
									context,
									"Loading...",
									Toast.LENGTH_SHORT
								)
								.show()
						}

						is Resource.Success -> {
							MovieList(it.result)
						}
					}
				}
			}
		}
	}
}
