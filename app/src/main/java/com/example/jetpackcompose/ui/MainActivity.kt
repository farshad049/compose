package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.bottomNavigation.MainScreenBottomNav
import com.example.jetpackcompose.ui.composeElements.AnimatedShimmer
import com.example.jetpackcompose.ui.composeElements.ButtonIncrease
import com.example.jetpackcompose.ui.composeElements.EasyShimmerItem
import com.example.jetpackcompose.ui.composeElements.RoundImageShape
import com.example.jetpackcompose.ui.composeElements.ShimmerGridItem
import com.example.jetpackcompose.ui.navigation.navGraph.SetupNavGraph
import com.example.jetpackcompose.ui.searchWidget.MainScreenSearchWidget
import com.example.jetpackcompose.ui.searchWidget.SearchWidgetViewModel
import com.example.jetpackcompose.ui.splashScreen.SplashSetupNavGraph
import com.example.jetpackcompose.ui.theme.*


class MainActivity : ComponentActivity() {

    private val viewModel: SearchWidgetViewModel by viewModels()

    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Column() {

                    //shimmer
//                    AnimatedShimmer {brush->
//                        repeat(7){
//                            ShimmerGridItem(brush)
//                        }
//                    }


                    //navigation
                    //navHostController= rememberNavController()
                    //SetupNavGraph(navController = navHostController)


                    //bottom navigation
                    //MainScreenBottomNav()


                    //topBar
                    //MainScreenSearchWidget(viewModel)

                    //splash screen
//                    val navHostController = rememberNavController()
//                    SplashSetupNavGraph(navHostController)

                    EasyShimmerItem()



                }



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