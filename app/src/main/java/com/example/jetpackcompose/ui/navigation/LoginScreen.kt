package com.example.jetpackcompose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.Constants.HOME_GRAPH

@Composable
fun LoginScreen(
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .height(250.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .clickable {
                               navController.navigate(Screens.Signup.route)
                    },
                text = "login",
                color = Color.Gray
            )

            Text(
                modifier = Modifier
                    .clickable {
                               navController.navigate(HOME_GRAPH){
                                   popUpTo(HOME_GRAPH)
                               }
                    },
                text = "go back"
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLogin(){
    LoginScreen(navController = rememberNavController())
}