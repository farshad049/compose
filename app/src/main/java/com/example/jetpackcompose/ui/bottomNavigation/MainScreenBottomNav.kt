package com.example.jetpackcompose.ui.bottomNavigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreenBottomNav(){
    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navHostController)
        }
    ) {
        BottomNavGraph(navHostController = navHostController)
    }
}



@Composable
fun BottomBar(navHostController: NavHostController){

    val screens= listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Profile,
        BottomBarScreens.Setting
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    BottomNavigation() {
        screens.forEach {screen->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController
            )

        }
        
    }
}



@Composable
fun RowScope.AddItem(
    screen: BottomBarScreens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
                },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription ="navigation icon"
            )
        },
        selected =  currentDestination?.hierarchy?.any(){
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled), // toma make the unSelected Item even less visible
        onClick = {
            navHostController.navigate(screen.route){
                popUpTo(navHostController.graph.findStartDestination().id) // get back to home screen when press back bottom
                launchSingleTop= true // the second touch on back bottom will exit the application since other copies of the start destination Id have been removed from backStack throw this piece of ode
            }
        }
    )
}