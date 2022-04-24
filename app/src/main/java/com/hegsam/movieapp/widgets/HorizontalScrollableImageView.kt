package com.hegsam.movieapp.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hegsam.movieapp.models.Movie

@Composable
fun HorizontalScrollableImageView(newMovieList: List<Movie>) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = 6.dp
    ) {

        LazyRow(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, contentPadding = PaddingValues(top = 22.dp, bottom = 22.dp)) {
            items(newMovieList.first().images) { image ->

                Spacer(modifier = Modifier.width(18.dp))
                
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Movie Images",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                corner = CornerSize(8.dp)
                            )
                        )
                        .height(125.dp)
                )
            }
        }

    }

}