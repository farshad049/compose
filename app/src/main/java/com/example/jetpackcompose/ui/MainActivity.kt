package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.composeElements.ButtonIncrease
import com.example.jetpackcompose.ui.theme.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                ButtonIncrease()
            }
        }
    }
}













@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        ButtonIncrease()
    }
}