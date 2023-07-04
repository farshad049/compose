@file:OptIn(ExperimentalFoundationApi::class)

package com.example.jetpackcompose.ui.lazyColumn

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun PersonItem(
    modifier: Modifier= Modifier ,
    person : PersonModel
){
    Row(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "${person.age}",
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








@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun PersonItemPreview(){
    JetpackComposeTheme{


        val personRepository = PersonRepository()
        var getAllData = personRepository.getAllData()
        var a by remember { mutableStateOf(getAllData) }

        LazyColumn(
            //padding for the whole recyclerview
            contentPadding = PaddingValues(all = 12.dp) ,
            //padding between each item in recyclerview
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){

            //use it in normal cases
            items(
                items = a, key = {it.id}
            ){ item->
                PersonItem(
                    modifier = Modifier.animateItemPlacement(),//make animation while item be deleted or in any other cases
                    person = item
                )
            }



            //use it when you need to have access to item index
//            itemsIndexed(
//                items = getAllData ,
//                key = { index, item ->
//                    item.id
//                }
//            ) { index, item ->
//                Log.d("mainActivity" , index.toString())
//                PersonItem(person = item)
//            }


            //use it when you want to add something at the end of the lazy column
            item {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    onClick = {
                        a= a.shuffled()
                    }
                ) {
                    Text(text = "shuffle")
                }
            }





        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview(showBackground = true)
fun PersonItemWithHeaderPreview(){
    JetpackComposeTheme{



        val personRepository = PersonRepository()
        val getAllData = personRepository.getAllData()

        LazyColumn(
            //padding for the whole recyclerview
            contentPadding = PaddingValues(all = 12.dp) ,
            //padding between each item in recyclerview
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            getAllData.groupBy { it.firstName.first() }.forEach { (FirstCharacter, personModels) ->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(12.dp),
                        text = "section $FirstCharacter"
                    )
                }
                items(personModels){
                    Text(
                        modifier = Modifier
                            .padding(12.dp) ,
                        text = it.firstName
                    )
                }

            }






            val headers = listOf("A" , "B" , "C" , "D" , "E" , "F" , "G")

            headers.forEach { header->
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
                        text = "item $it from section $headers"
                    )
                }

            }




        }

    }

}