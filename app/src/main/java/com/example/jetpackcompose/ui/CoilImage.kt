package com.example.jetpackcompose.ui

import android.content.Context
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.jetpackcompose.R


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
                .crossfade(500)
                .error(R.drawable.ic_baseline_priority_high_24)
                .transformations(
                   // CircleCropTransformation() ,
                   // RoundedCornersTransformation(bottomLeft = 100f)
                )
                .build(),
            placeholder = painterResource(R.drawable.ic_baseline_image_24) ,
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape),
        )


    }
}



@Composable
fun CoilImage2(imageUrl: String){
    Box(modifier = Modifier
        .width(150.dp)
        .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(500)
                .error(R.drawable.ic_baseline_priority_high_24)
                .placeholder(R.drawable.ic_baseline_image_24)
                .build()
            ,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape),
        ) {

            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator()
            } else {
                SubcomposeAsyncImageContent()
            }

        }

    }

}





@Composable
@Preview(showBackground = true)
fun ImagePreview(){
    Column() {
        CoilImage()
        CoilImage2(imageUrl = "https://static.remove.bg/remove-bg-web/c4b29bf4b97131238fda6316e24c9b3606c18000/assets/start_remove-c851bdf8d3127a24e2d137a55b1b427378cd17385b01aec6e59d5d4b5f39d2ec.png")
    }


}