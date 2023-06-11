package com.example.jetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

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
fun ButtonIncreasePreview() {
    JetpackComposeTheme {
        ButtonIncrease()
    }
}