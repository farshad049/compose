package com.example.jetpackcompose.ui.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpackcompose.ui.Constants.AUTH_GRAPH
import com.example.jetpackcompose.ui.navigation.LoginScreen
import com.example.jetpackcompose.ui.navigation.Screens
import com.example.jetpackcompose.ui.navigation.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){

    //nested navigation
    navigation(
        startDestination = Screens.Login.route,
        route = AUTH_GRAPH
    ){
        composable(
            route = Screens.Login.route
        ){
            LoginScreen(navController = navController)
        }

        composable(
            route = Screens.Signup.route
        ){
            SignUpScreen(navController = navController)
        }
    }

}