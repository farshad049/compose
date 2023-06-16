package com.example.jetpackcompose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SearchScreen(
    navController: NavController
){
    Box(
        modifier = Modifier.
        fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(Screens.Home.route) {
                        popUpTo(Screens.Home.route) {//make stack empty after moving to last page
                            inclusive = true
                        }
                    }
                },
            text = "go to home screen",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }

}