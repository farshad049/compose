package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.jetpackcompose.ui.TopbarSearchWidget.SearchWidgetViewModel
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.jetpackcompose.ui.animatedBottomBar.AnimatedBottomBarScreen
import com.example.jetpackcompose.ui.composeElements.DarkAndLightThemeSwitcher
import com.example.jetpackcompose.ui.composeElements.EasyShimmerItem
import com.example.jetpackcompose.ui.composeElements.FadeInShimmer
import com.example.jetpackcompose.ui.composeElements.LottieAnimationScreen
import com.example.jetpackcompose.ui.composeElements.MarqueeEffect
import com.example.jetpackcompose.ui.composeElements.PhotoPickerScreen
import com.example.jetpackcompose.ui.lazyColumn.ScrollDetector

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SearchWidgetViewModel by viewModels()

    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //  var darkTheme by remember { mutableStateOf(false) }
            JetpackComposeTheme(
                //darkTheme = darkTheme
            ) {
                Column() {

//                    DarkAndLightThemeSwitcher(
//                        darkTheme= darkTheme,
//                        onThemeUpdated = {darkTheme = !darkTheme}
//                    )

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

                    //EasyShimmerItem()


                    //selectable Item
//                    var selected by remember { mutableStateOf(false) }
//                    SelectableItem(
//                        title = "salam",
//                        selected = selected,
//                        onClick = {selected = !selected},
//                    )






                    AnimatedBottomBarScreen()









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