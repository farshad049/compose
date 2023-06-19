package com.example.jetpackcompose.ui.navigation.navGraph

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.jetpackcompose.ui.Constants.DETAIL_SCREEN_KEY
import com.example.jetpackcompose.ui.Constants.DETAIL_SCREEN_KEY2
import com.example.jetpackcompose.ui.Constants.HOME_GRAPH
import com.example.jetpackcompose.ui.Constants.SEARCH_SCREEN_KEY
import com.example.jetpackcompose.ui.Constants.SEARCH_SCREEN_KEY2
import com.example.jetpackcompose.ui.navigation.DetailScreen
import com.example.jetpackcompose.ui.navigation.HomeScreen
import com.example.jetpackcompose.ui.navigation.Screens
import com.example.jetpackcompose.ui.navigation.SearchScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Screens.Home.route,
        route = HOME_GRAPH
    ){

        composable(route= Screens.Home.route){
            HomeScreen(navController= navController)
        }


        composable(
            route = Screens.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_SCREEN_KEY){
                    type= NavType.IntType
                },
                navArgument(DETAIL_SCREEN_KEY2){
                    type= NavType.StringType
                }
            )
        ){
            DetailScreen(navController = navController)
        }



        composable(
            route = Screens.Search.route,
            arguments = listOf(
                navArgument(SEARCH_SCREEN_KEY){
                    type= NavType.IntType
                    defaultValue = 0
                },
                navArgument(SEARCH_SCREEN_KEY2){
                    type= NavType.StringType
                    defaultValue= "farshad"
                }
            )
        ){
            Log.d("ARG", it.arguments?.getInt("id").toString())
            Log.d("Arg", it.arguments?.getString("name").toString())
            SearchScreen(navController = navController)
        }

    }

}