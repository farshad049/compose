package com.example.jetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.LightGray


@Composable
fun CoilImage(){
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp) ,
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://static.remove.bg/remove-bg-web/c4b29bf4b97131238fda6316e24c9b3606c18000/assets/start_remove-c851bdf8d3127a24e2d137a55b1b427378cd17385b01aec6e59d5d4b5f39d2ec.png")
                .crossfade(1000)
                .error(R.drawable.ic_baseline_priority_high_24)
                .transformations(
                   // CircleCropTransformation() ,
                   // RoundedCornersTransformation(bottomLeft = 100f)
                )
                .build(),
            placeholder = painterResource(R.drawable.ic_baseline_image_24) ,
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )


    }
}

@Composable
@Preview
fun ImagePreview(){
    CoilImage()
}