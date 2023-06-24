package com.example.jetpackcompose.ui.splashScreen

sealed class SplashScreens(val route: String){
    object Splash: SplashScreens(route = "splash_screen")
    object Home: SplashScreens(route = "home_screen")
}
