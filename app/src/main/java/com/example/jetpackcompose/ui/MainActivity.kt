package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.bottomNavigation.MainScreenBottomNav
import com.example.jetpackcompose.ui.composeElements.ButtonIncrease
import com.example.jetpackcompose.ui.navigation.navGraph.SetupNavGraph
import com.example.jetpackcompose.ui.theme.*


class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
//                navHostController= rememberNavController()
//                SetupNavGraph(navController = navHostController)

                MainScreenBottomNav()


            }
        }
    }
}













@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {

    }
}