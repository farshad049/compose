package com.example.jetpackcompose.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.lazyColumn.PersonItem
import com.example.jetpackcompose.ui.lazyColumn.model.PersonRepository
import com.example.jetpackcompose.ui.theme.*


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val headersList = listOf("A" , "B" , "C" , "D" , "E" , "F" , "G")

                LazyColumn(
                    //padding for the whole recyclerview
                    contentPadding = PaddingValues(all = 12.dp) ,
                    //padding between each item in recyclerview
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    headersList.forEach { header->
                        stickyHeader {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                                    .padding(12.dp) ,

                                text = "section $header"
                            )
                        }
                        items(10){
                            Text(
                                modifier = Modifier
                                    .padding(12.dp) ,
                                text = "item $it from section $header"
                            )
                        }

                    }

                }
            }
        }
    }
}













@Composable
fun surfaces(){
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp) ,
        color = Color.Yellow

    ) {

    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(12.dp)
        ) {
            TextField()
        }

    }
}