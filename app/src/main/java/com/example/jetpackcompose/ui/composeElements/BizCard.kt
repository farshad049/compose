package com.example.jetpackcompose.ui.composeElements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@Composable
fun BizCard(){
    val buttonClickState = remember { mutableStateOf(false)}
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(12.dp)
                ,
            elevation = 6.dp ,
            shape = RoundedCornerShape(corner = CornerSize(12.dp)) ,
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                Divider(
                    modifier = Modifier
                        .padding(8.dp),
                    thickness = 1.dp ,
                    color = Color.Blue ,
                    startIndent = 5.dp ,
                )
                TextInfo()
                Button(
                    modifier = Modifier
                        .padding(top = 12.dp),
                    onClick = {
                        buttonClickState.value = !buttonClickState.value

                              } ,
                   
                ) {
                    Text(
                        text = "Click" ,
                        style = MaterialTheme.typography.button ,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (buttonClickState.value){
                    BoxContent()
                }else{
                    Box() {
                        
                    }

                }


            }

        }

    }

}

@Composable
private fun BoxContent(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp) ,
            border = BorderStroke(1.dp , MaterialTheme.colors.primaryVariant) ,
            shape = RoundedCornerShape(8.dp)
        ) {
            Portfolio(listOf("project 1" , "project 2" , "project 3"))


        }

    }

}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){ item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp) ,
                elevation = 6.dp ,
                shape = RoundedCornerShape(6.dp) ,
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight() ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Start
                ) {
                    ProfileImage(modifier = Modifier.size(80.dp) , border = BorderStroke(1.dp , Color.DarkGray))
                    Column(
                        modifier = Modifier.wrapContentWidth() ,
                        horizontalAlignment = Alignment.Start ,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = item , fontWeight = FontWeight.Bold)
                        Text(text = "a great project indeed")
                    }

                }

            }
        }
    }

}


@Composable
private fun TextInfo() {
    Column() {
        Text(
            text = "Farshad",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Android Compose Program",
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "@Tweeter",
            style = MaterialTheme.typography.subtitle1
        )
    }
}


@Composable
private fun ProfileImage(modifier : Modifier = Modifier , border :BorderStroke = BorderStroke(1.dp, Color.LightGray)) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = border,
        elevation = 6.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )

    }
}









@Composable
@Preview
fun BizCardPreview(){
    BizCard()
}