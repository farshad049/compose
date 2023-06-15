package com.example.jetpackcompose.ui.composeElements

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    shape : CornerBasedShape = Shapes.medium,
    title : String,
    titleFontSize : TextUnit = MaterialTheme.typography.h6.fontSize ,
    titleFontWeight : FontWeight = FontWeight.Bold ,
    description : String ,
    descriptionFontSize : TextUnit = MaterialTheme.typography.subtitle1.fontSize ,
    descriptionFontWeight : FontWeight = FontWeight.Normal

){
    var expandableState by remember { mutableStateOf(false)}

    val rotationState by animateFloatAsState(
        targetValue = if (expandableState) 180f else 0f
            )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ) ,
        shape = shape ,
        onClick = { expandableState = !expandableState }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(8f),
                    text = title ,
                    fontWeight = titleFontWeight,
                    fontSize = titleFontSize ,
                    maxLines = 1 ,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = { expandableState = !expandableState } ,
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop-down-arrow")
                }
            }
            if (expandableState){
                Text(
                    text = description ,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight ,
                    maxLines = 4 ,
                    overflow = TextOverflow.Ellipsis

                )
            }

        }

    }

}


@Composable
@Preview
fun ExpandableCardPreview(){
    JetpackComposeTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(12.dp)

            ,
        ) {
            ExpandableCard(
                title = "title",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                        " when an unknown printer took a galley of type and scrambled it to make a type specimen book",
                shape = Shapes.small
            )
        }
    }


}