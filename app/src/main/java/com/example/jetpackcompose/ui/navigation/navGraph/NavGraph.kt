package com.example.jetpackcompose.ui.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.jetpackcompose.ui.Constants.HOME_GRAPH
import com.example.jetpackcompose.ui.Constants.ROOT_GRAPH
import com.example.jetpackcompose.ui.navigation.viewModel.FavoriteViewModel


@Composable
fun SetupNavGraph(
    navController: NavHostController,
){
    val sharedViewModel: FavoriteViewModel= viewModel()// to pass object to favorite screen


    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH,
        route = ROOT_GRAPH
    ){
        homeNavGraph(navController = navController, sharedViewModel)
        authNavGraph(navController = navController)
    }
}