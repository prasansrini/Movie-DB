package com.my.movie.db.ui.movies

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.my.movie.db.R
import com.my.movie.db.data.model.Movie
import com.my.movie.db.ui.theme.AppTheme
import com.my.movie.db.ui.theme.spacing

@Composable
fun MovieItem(
	item: Movie?
) {
	val spacing = MaterialTheme.spacing
	Box(
		modifier = Modifier
			.background(
				brush = Brush.linearGradient(
					colors = listOf(
						MaterialTheme.colorScheme.surfaceVariant,
						MaterialTheme.colorScheme.surface
					),
					start = Offset(
						0f,
						Float.POSITIVE_INFINITY
					),
					end = Offset(
						Float.POSITIVE_INFINITY,
						0f
					)
				)
			)
			.fillMaxWidth()
			.wrapContentHeight()
			.padding(spacing.extraSmall)
			.clip(RoundedCornerShape(spacing.small))
			.shadow(elevation = 1.dp)
	) {

		Row(
			modifier = Modifier
				.padding(spacing.small)
				.fillMaxWidth()
		) {

			AsyncImage(
				model = ImageRequest
					.Builder(LocalContext.current)
					.data(item?.fullPosterPath ?: "Preview URL")
					.crossfade(true)
					.build(),
				placeholder = painterResource(R.drawable.bg_image_placeholder),
				contentDescription = "",
				contentScale = ContentScale.Fit,
				modifier = Modifier.weight(0.4f)
			)

			Column(
				modifier = Modifier
					.weight(0.6f)
					.padding(start = spacing.medium)
			) {
				Text(
					text = item?.title ?: "Preview Title",
					style = MaterialTheme.typography.titleLarge,
					color = MaterialTheme.colorScheme.onSurface
				)

				Spacer(modifier = Modifier.size(spacing.medium))

				Text(
					text = item?.overview ?: "Preview Overview",
					style = MaterialTheme.typography.bodyMedium,
					color = MaterialTheme.colorScheme.onSurface,
					maxLines = 7,
					overflow = TextOverflow.Ellipsis
				)

				Spacer(modifier = Modifier.size(spacing.medium))

				Text(
					text = "IMDB ${item?.voteAverage ?: "Preview Rating"}",
					style = MaterialTheme.typography.bodySmall,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.clip(RoundedCornerShape(spacing.extraSmall))
						.background(Color.Yellow)
						.padding(
							start = spacing.small,
							end = spacing.small,
							top = spacing.extraSmall,
							bottom = spacing.extraSmall
						)
				)
			}
		}
	}
}

@Preview(
	showBackground = true,
	uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MovieItemPreviewDark() {
	AppTheme {
		MovieItem(null)
	}
}

@Preview(
	showBackground = true,
	uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun MovieItemPreviewLight() {
	AppTheme {
		MovieItem(null)
	}
}
