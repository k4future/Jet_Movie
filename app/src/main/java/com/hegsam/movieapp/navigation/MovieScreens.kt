package com.hegsam.movieapp.navigation

enum class MovieScreens {
    HomeScreen, DetailedScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailedScreen.name -> DetailedScreen
            null -> HomeScreen

            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}