package com.hegsam.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hegsam.movieapp.models.getMovies
import com.hegsam.movieapp.widgets.HorizontalScrollableImageView
import com.hegsam.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {

    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable { navController.popBackStack() })

                Spacer(modifier = Modifier.width(15.dp))

                Text(text = "Movies")

            }
        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                MovieRow(movie = newMovieList.first())

                Spacer(modifier = Modifier.height(8.dp))

                Divider()

                Text(text = "Movie Images")

                HorizontalScrollableImageView(newMovieList)
            }
        }
    }

}