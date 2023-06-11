package com.example.jetpackcompose.ui


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter


@Composable
fun PasswordField(outCome: (String) -> Unit){
    var password by rememberSaveable { mutableStateOf("")}
    var passwordVisibility by rememberSaveable { mutableStateOf(false)}

    val icon = if(passwordVisibility){
        painterResource(id = com.example.jetpackcompose.R.drawable.ic_baseline_visibility_24)
    }else{
        painterResource(id = com.example.jetpackcompose.R.drawable.ic_baseline_visibility_off_24)
    }






    OutlinedTextField(
        value = password ,
        onValueChange = {
            password = it
            outCome(password)
                        } ,
        placeholder = { Text(text = "password")} ,
        label = { Text(text = "password")} ,
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = ! passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "visibility icon"
                )
            }
        } ,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation() ,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )




}





@Composable
@Preview(showBackground = true)
fun PasswordFieldPreview(){
    PasswordField(outCome = {})
}
