package com.example.jetpackcompose.ui.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.jetpackcompose.ui.Constants.HOME_GRAPH
import com.example.jetpackcompose.ui.Constants.ROOT_GRAPH
import com.example.jetpackcompose.ui.navigation.Screens

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH,
        route = ROOT_GRAPH
    ){
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}