package com.example.jetpackcompose.ui.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens (
    val route: String,
    val title: String,
    val icon: ImageVector
        ){

    object Home: BottomBarScreens(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile: BottomBarScreens(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Setting: BottomBarScreens(
        route = "setting",
        title = "Setting",
        icon = Icons.Default.Settings
    )

}