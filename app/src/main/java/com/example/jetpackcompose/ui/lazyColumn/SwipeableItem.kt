package com.example.jetpackcompose.ui.lazyColumn

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.lazyColumn.model.PersonModel
import com.example.jetpackcompose.ui.lazyColumn.model.PersonRepository
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.Typography
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox


@Composable
fun SwipeableItem(
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
fun SwipeablePreview(){

        val personRepository = PersonRepository()
        var getAllData = personRepository.getAllData()
        var a by remember { mutableStateOf(getAllData) }

    val archive = SwipeAction(
        icon = rememberVectorPainter(Icons.Default.Add),
        background = Color.Green,
        onSwipe = { Log.e("archive","archive") }
    )

    val snooze = SwipeAction(
        icon = { Text("Snooze") },
        background = Color.Yellow,
        isUndo = true,
        onSwipe = { Log.e("Snooze","Snooze")  },
    )

            LazyColumn(
                contentPadding = PaddingValues(all = 12.dp) ,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(items = a, key = {it.id}){ item->

                    SwipeableActionsBox(
                        startActions = listOf(archive),
                        endActions = listOf(snooze),
                        swipeThreshold = 200.dp //should swipe for 200dp to make it work
                    ) {
                        PersonItem(
                            modifier = Modifier,
                            person = item
                        )
                    }

                }
            }
    }
