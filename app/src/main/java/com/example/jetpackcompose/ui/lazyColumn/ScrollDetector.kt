package com.example.jetpackcompose.ui.lazyColumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.lazyColumn.model.PersonRepository


@Composable
fun ScrollDetector(){
    val lazyListState= rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize()) {
        DataList(listState = lazyListState)
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = if (lazyListState.isScrolled) "scrolling" else "idle"
        )

    }


}


@Composable
fun DataList(listState: LazyListState){
    val personRepository = PersonRepository()
    var getAllData = personRepository.getAllData()
    var a by remember { mutableStateOf(getAllData) }

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp) ,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        state = listState
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

val LazyListState.isScrolled: Boolean
    get()= firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0  //to figure out if list is scrolling or in the first origin  position