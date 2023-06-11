package com.example.jetpackcompose.ui

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TextField(outCome: (String)-> Unit){
    var text by rememberSaveable { mutableStateOf("") }


    //or TextField or BasicTextField
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            outCome(text)
                        } ,
        placeholder = { Text(text = "type here...")} ,
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
@Preview(showBackground = true)
fun TextFieldPreview(){
    TextField({})
}