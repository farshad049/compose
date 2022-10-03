package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.*
import okhttp3.internal.wait


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




@Composable
fun ButtonIncrease(){
    var price = 100
    var moneyCounter by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colors.primaryVariant)
                .clickable {
                    moneyCounter += 1
                    price += moneyCounter
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally ,
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 24.dp) ,
                text = "$ $moneyCounter" ,
                fontSize = 24.sp ,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(
                modifier = Modifier.
                height(300.dp)
            )

            CreateCircle(moneyCounter = moneyCounter ){
                moneyCounter = it
            }




        }





}

@Composable
fun CreateCircle(moneyCounter : Int = 0 , updatedMoneyCounter : (Int)->(Unit)){
    Surface(
        modifier = Modifier
            .size(200.dp)
            .clickable {
               updatedMoneyCounter (moneyCounter + 1)
            },
        shape = CircleShape,
        color = Color.White ,
        elevation = 8.dp ,

        ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Tap $moneyCounter" ,
                fontSize = 36.sp ,
                fontWeight = FontWeight.Bold
            )
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