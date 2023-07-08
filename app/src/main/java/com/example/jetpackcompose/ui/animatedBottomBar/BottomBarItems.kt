package com.example.jetpackcompose.ui.animatedBottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarItems (
    val route: String,
    val title: String,
    val icon: ImageVector
        ){

    Home(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    ),
    Profile(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    ),
    Setting(
        route = "setting",
        title = "Setting",
        icon = Icons.Default.Settings
    )

}