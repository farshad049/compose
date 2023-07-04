package com.example.jetpackcompose.ui.composeElements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun FadeInAndOutAnimation(view :@Composable ()-> Unit) {
    var visibility by remember { mutableStateOf(false) }

    Column() {
        Button(onClick = { visibility = !visibility}) {
            Text(text = "Click")

        }
        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        ) {
            view()
        }
    }
}