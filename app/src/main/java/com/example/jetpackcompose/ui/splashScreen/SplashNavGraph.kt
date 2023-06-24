package com.example.jetpackcompose.ui.splashScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.Constants
import com.example.jetpackcompose.ui.navigation.HomeScreen
import com.example.jetpackcompose.ui.navigation.Screens
import com.example.jetpackcompose.ui.navigation.navGraph.authNavGraph
import com.example.jetpackcompose.ui.navigation.navGraph.homeNavGraph

@Composable
fun SplashSetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = SplashScreens.Splash.route,
    ){

        composable(route= SplashScreens.Splash.route){
            AnimatedSplash(navController)
        }

        composable(route= SplashScreens.Home.route){
            Box(modifier = Modifier.fillMaxSize())

        }

        

    }
}