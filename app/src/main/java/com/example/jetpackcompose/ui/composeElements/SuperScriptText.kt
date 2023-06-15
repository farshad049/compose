package com.example.jetpackcompose.ui.composeElements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun SuperScriptText(
    normalText:String,
    superScript:String,
    normalTextFontSize : TextUnit = 20.sp,
    superScriptTextSize : TextUnit = 12.sp
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