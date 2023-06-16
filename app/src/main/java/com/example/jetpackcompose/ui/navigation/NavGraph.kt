package com.example.jetpackcompose.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){


        composable(
            route= Screens.Home.route
        ){
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