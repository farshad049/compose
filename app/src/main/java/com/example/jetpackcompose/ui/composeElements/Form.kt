package com.example.jetpackcompose.ui.composeElements

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Form(){
    Column() {
        var a : String=""
        var b : String=""
        TextField { esm -> a = esm }
        PasswordField { pass -> b = pass }

        Button(
            onClick = {
                Log.e("SALAM", "$a + $b")
            }) {
            Text(text = "click here")

        }
    }

}


@Composable
@Preview(showBackground = true)
fun FormPreview(){
    Form()
}