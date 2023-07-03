package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.navigation.navGraph.SetupNavGraph
import com.example.jetpackcompose.ui.TopbarSearchWidget.SearchWidgetViewModel
import com.example.jetpackcompose.ui.composeElements.LoadingAnimation
import com.example.jetpackcompose.ui.composeElements.SelectableItem
import com.example.jetpackcompose.ui.splashScreen.AnimatedSplash
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.jetpackcompose.ui.BoxWithConstraints.BoxWithConstraintScreen
import com.example.jetpackcompose.ui.lazyColumn.SwipeablePreview

@AndroidEntryPoint
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
//                    navHostController= rememberNavController()
//                    SetupNavGraph(navController = navHostController)


                    //bottom navigation
                    //MainScreenBottomNav()


                    //topBar
                    //MainScreenSearchWidget(viewModel)

                    //splash screen
//                    val navHostController = rememberNavController()
//                    SplashSetupNavGraph(navHostController)

//                    EasyShimmerItem()


                    //selectable Item
//                    var selected by remember { mutableStateOf(false) }
//                    SelectableItem(
//                        title = "salam",
//                        selected = selected,
//                        onClick = {selected = !selected},
//                    )

                    BoxWithConstraintScreen()







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