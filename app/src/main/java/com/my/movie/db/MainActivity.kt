package com.my.movie.db

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.my.movie.db.ui.theme.AppTheme
import net.simplifiedcoding.tmdbmovies.ui.movies.MovieList

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			AppTheme {
				MovieList()
			}
		}
	}
}
