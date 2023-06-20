package com.example.jetpackcompose.ui.composeElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@Composable
fun RoundImageShape(){
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(
                width = 2.dp,
                color = Color.Cyan,
                shape = RoundedCornerShape(15.dp)
            ),
        painter = painterResource(id = R.drawable.image),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}


@Preview()
@Composable
fun PreviewImageShape(){
    RoundImageShape()
}
