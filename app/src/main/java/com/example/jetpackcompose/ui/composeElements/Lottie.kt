package com.example.jetpackcompose.ui.composeElements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jetpackcompose.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.airbnb.lottie.compose.animateLottieCompositionAsState

@Composable
fun LottieAnimationScreen(){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.policeman))
    var isPlaying by remember { mutableStateOf(true) }
    val progress by animateLottieCompositionAsState(composition = composition, isPlaying= isPlaying)

    LaunchedEffect(key1 = progress ){
        if (progress == 0f) isPlaying= true
        if (progress == 1f) isPlaying= false
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            LottieAnimation(
                modifier = Modifier.size(300.dp),
                composition = composition,
                progress = {progress}
            )
            Button(onClick = { isPlaying= true}) {
                Text(text = "play again")
            }
        }


    }
}