package com.example.matherial3.ComposeElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenWithTopBar(){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior= scrollBehavior,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "" )
                    }
                },
                title = {
                    Text(text = "home")
                },
            )
        },
        content = {paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = paddingValues.calculateBottomPadding())//set bottom padding for main activity in order so content could be shown without the bottom of them become clipped
            ) {
                DataList()
            }
        }
    )
}




@Composable
fun DataList(){
    val personRepository = PersonRepository()
    var getAllData = personRepository.getAllData()
    var a by remember { mutableStateOf(getAllData) }

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp) ,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {


        items(
            items = a, key = { it.id }
        ) { item ->
            PersonItem(
                person = item
            )
        }

    }
}


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
            fontSize = MaterialTheme.typography.bodyMedium.fontSize ,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName ,
            color = Color.Black ,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize ,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName ,
            color = Color.Black ,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize ,
            fontWeight = FontWeight.Normal
        )

    }

}