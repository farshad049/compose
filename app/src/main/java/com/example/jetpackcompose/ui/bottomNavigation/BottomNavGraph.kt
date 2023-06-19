package com.example.jetpackcompose.ui.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreens.Home.route
    ){

        composable(route = BottomBarScreens.Home.route){
            HomeNavigationBottom()
        }

        composable(route = BottomBarScreens.Profile.route){
            ProfileNavigationBottom()
        }

        composable(route = BottomBarScreens.Setting.route){
            SettingNavigationBottom()
        }



    }
}