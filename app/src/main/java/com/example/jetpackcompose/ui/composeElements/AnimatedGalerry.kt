package com.example.jetpackcompose.ui.composeElements

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimatedGallery(){
    val images = remember {
        mutableListOf(
            "https://www.mizanonline.ir/wp-content/uploads/2022/02/2307048_331.jpg",
            "https://cdn.nody.ir/files/2021/07/02/nody-%D8%B9%DA%A9%D8%B3-%D8%B7%D8%A8%DB%8C%D8%B9%D8%AA-%D9%81%D9%88%D9%82-%D8%A7%D9%84%D8%B9%D8%A7%D8%AF%D9%87-%D8%B2%DB%8C%D8%A8%D8%A7-1625207714.jpg",
        )
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { images.size }

    val matrix = remember { ColorMatrix()  }

    Box(
        modifier = Modifier.padding(vertical = 48.dp)
    ) {
        HorizontalPager(state = pagerState) {index->
            val pageOffset= (pagerState.currentPage- index) + (pagerState.currentPageOffsetFraction)
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                animationSpec = tween(durationMillis = 300)
            )

            LaunchedEffect(key1 = imageSize){
                if (pageOffset != 0.0f){
                    matrix.setToSaturation(0f)
                }else{
                    matrix.setToSaturation(1f)
                }

            }

            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                    },
                model = ImageRequest.Builder(LocalContext.current)
                    .data(images[index])
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(matrix)
            )
            
        }


    }



}