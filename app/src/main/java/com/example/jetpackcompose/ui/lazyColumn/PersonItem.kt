package com.example.jetpackcompose.ui.lazyColumn

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.lazyColumn.model.PersonModel
import com.example.jetpackcompose.ui.lazyColumn.model.PersonRepository
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.Typography

@Composable
fun PersonItem(person : PersonModel){
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(24.dp) ,
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "${person.age}" ,
            color = Color.Black ,
            fontSize = Typography.h4.fontSize ,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName ,
            color = Color.Black ,
            fontSize = Typography.h5.fontSize ,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName ,
            color = Color.Black ,
            fontSize = Typography.h5.fontSize ,
            fontWeight = FontWeight.Normal
        )

    }

}


@Composable
fun PersonItemWithHeader(){

}








@Composable
@Preview
fun PersonItemPreview(){
    JetpackComposeTheme{

        val personRepository = PersonRepository()
        val getAllData = personRepository.getAllData()

        LazyColumn(
            //padding for the whole recyclerview
            contentPadding = PaddingValues(all = 12.dp) ,
            //padding between each item in recyclerview
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            items(items = getAllData){ item->
                PersonItem(person = item)
            }

            itemsIndexed(
                items = getAllData ,
                key = { index, item ->
                    item.id
                }
            ) { index, item ->
                Log.d("mainActivity" , index.toString())
                PersonItem(person = item)
            }
        }

    }

}



@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun PersonItemWithHeaderPreview(){
    JetpackComposeTheme{

        val headers = listOf("A" , "B" , "C" , "D" , "E" , "F" , "G")

        LazyColumn(
            //padding for the whole recyclerview
            contentPadding = PaddingValues(all = 12.dp) ,
            //padding between each item in recyclerview
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            headers.forEach { header->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(12.dp) ,

                        text = "section $headers"
                    )
                }
                items(10){
                    Text(
                        modifier = Modifier
                            .padding(12.dp) ,
                        text = "item $it from section $headers"
                    )
                }

            }

        }

    }

}