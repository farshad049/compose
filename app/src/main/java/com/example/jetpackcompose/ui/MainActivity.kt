package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                        .padding(12.dp) ,
                    horizontalAlignment = Alignment.CenterHorizontally ,
                    verticalArrangement = Arrangement.Center
                ) {
                    GradientButton(
                        text = "click me",
                        textColor = Color.Red,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(Color1 , Color2)
                        )
                    ) {

                    }
                }
            }
        }
    }
}






@Composable
fun customText(){
    Text(
        buildAnnotatedString {

                withStyle(
                    style =SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append("F")
                }
                append("a")
                append("r")
                append("s")
                append("h")
                append("a")
                append("d")


        },Modifier.width(200.dp)
    )
}

@Composable
fun customText2(){
        Text(text = "hello farshad".repeat(20) , maxLines = 2 , overflow = TextOverflow.Ellipsis)
}

@Composable
fun customText3(){
    SelectionContainer() {
        Column() {
            Text(text = "googooli")
            DisableSelection {
                Text(text = "googooli")
            }
            Text(text = "googooli")
        }
    }
}

@Composable
fun SuperScriptText(
    normalText:String ,
    superScript:String ,
    normalTextFontSize : TextUnit = 20.sp ,
    superScriptTextSize :TextUnit = 12.sp
){
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(fontSize = normalTextFontSize , fontWeight = FontWeight.Bold)
        ){
            append(normalText)
        }

        withStyle(
            style = SpanStyle(fontSize = superScriptTextSize, baselineShift = BaselineShift.Subscript)
        ){
            append(superScript)
        }
    })
}


@Composable
fun surfaces(){
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp) ,
        color = Color.Yellow

    ) {

    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(12.dp)
        ) {
            TextField()
        }

    }
}