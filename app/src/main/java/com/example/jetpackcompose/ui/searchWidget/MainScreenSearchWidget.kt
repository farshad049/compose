package com.example.jetpackcompose.ui.searchWidget


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.bottomNavigation.BottomNavGraph


@Composable
fun MainScreenSearchWidget(viewModel: SearchWidgetViewModel){

    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState

    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {viewModel.updateSearchTextState(newValue = it)},
                onCloseClicked = { viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)},
                onSearchClicked = { Log.e("SEARCH", it)},
                onSearchTriggered = { viewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)}
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())//set bottom padding for main activity in order so content could be shown without the bottom of them become clipped
        ) {}
    }
}




@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
){
    when(searchWidgetState){
        SearchWidgetState.CLOSED -> {
            DefaultAppBar (
                onSearchClick = onSearchTriggered
                    )
        }
        SearchWidgetState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClick = { onCloseClicked()},
                onSearchClick = onSearchClicked
            )
        }

    }

}


@Composable
fun DefaultAppBar(onSearchClick: ()-> Unit){
    TopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            IconButton(onClick = {onSearchClick()}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
    )
}



@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String)-> Unit,
    onCloseClick: ()-> Unit,
    onSearchClick: (String)-> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.primary
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {onTextChange(it)},
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Type here..."
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
              IconButton(
                  modifier = Modifier.alpha(ContentAlpha.medium),
                  onClick = {}
              ) {
                 Icon(
                     imageVector = Icons.Default.Search,
                     contentDescription = "",
                     tint = Color.White
                 )
              }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                    if (text.isNotEmpty()) onTextChange("") else onCloseClick()
                    }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            },
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClick(text)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,// remove the background color of textfiel itself
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )
        )

    }

}









@Preview(showBackground = true)
@Composable
fun PreviewAppBar(){
    DefaultAppBar(onSearchClick = {})
}


@Preview(showBackground = true)
@Composable
fun PreviewSearchWidget(){
    SearchAppBar(
        text = "random text",
        onTextChange = {},
        onCloseClick = {},
        onSearchClick ={}
    )
}

