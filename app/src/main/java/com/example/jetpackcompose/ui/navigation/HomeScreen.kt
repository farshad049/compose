package com.example.jetpackcompose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.Detail.passNameAndId(id = 1, name = "farshad"))
                    },
                text = "go to detail screen",
                fontSize = MaterialTheme.typography.h4.fontSize

            )

            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.Search.passIDAndName())
                    },
                text = "go to search screen",
                fontSize = MaterialTheme.typography.h4.fontSize

            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen(navController = rememberNavController())
}

