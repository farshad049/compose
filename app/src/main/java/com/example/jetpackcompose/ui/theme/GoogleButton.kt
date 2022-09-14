package com.example.jetpackcompose.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(
    text : String = "Sign Up With Google" ,
    loadingText : String = "Creating Account..." ,
    icon : Painter = painterResource(id = com.example.jetpackcompose.R.drawable.google_icon) ,
    shape : Shape = Shapes.medium ,
    backgroundColor : Color = MaterialTheme.colors.surface ,
    onClick : () -> Unit
){
    var clicked by remember { mutableStateOf(false) }

    Surface(
        onClick = { clicked = !clicked} ,
        shape = shape ,
        border = BorderStroke(width = 1.dp , color = Color.LightGray) ,
        color = backgroundColor,
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp ,
                    end = 16.dp ,
                    top = 12.dp ,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center ,
        ) {

            Icon(
                painter = icon,
                contentDescription = "google icon" ,
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if( clicked) loadingText else text)

            Spacer(modifier = Modifier.width(8.dp))

            if (clicked){
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )

                onClick()

            }
        }
    }

}




@ExperimentalMaterialApi
@Composable
@Preview
private fun GoogleButtonPreview(){
    GoogleButton(
        onClick = {}
    )
}