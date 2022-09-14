package com.example.jetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme



@Composable
fun TextField(){
    var text by remember { mutableStateOf("type here...") }

    //or TextField or BasicTextField
    OutlinedTextField(
        value = text,
        onValueChange = { text = it} ,
        label = { Text(text = "name")} ,
        singleLine = true ,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector =Icons.Default.Email , contentDescription = "email icon")
            }
        } ,
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector =Icons.Default.Home , contentDescription = "home icon")
            }
        } ,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email ,
            imeAction = ImeAction.Done
        ) ,
        keyboardActions = KeyboardActions(
            onDone =  {}
        )

    )

}





@Composable
@Preview
fun TextFieldPreview(){
    JetpackComposeTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background) ,
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center
        ) {
            TextField()
        }
    }
}