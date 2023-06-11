package com.example.jetpackcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun customText(){
    Text(
        buildAnnotatedString {

            withStyle(
                style = SpanStyle(
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


        }, Modifier.width(200.dp)
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


@Preview(showBackground = true)
@Composable
fun CustomTextPreview(){
    Column() {
        customText()
        customText2()
        customText3()
    }

}