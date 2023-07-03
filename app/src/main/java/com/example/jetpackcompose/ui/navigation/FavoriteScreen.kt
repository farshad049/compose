package com.example.jetpackcompose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetpackcompose.ui.navigation.model.FavoritePerson
import com.example.jetpackcompose.ui.navigation.viewModel.FavoriteViewModel


@Composable
fun FavoriteScreen(
    navHostController: NavHostController,
    sharedViewModel: FavoriteViewModel
){

    val person= sharedViewModel.person

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navHostController.popBackStack() },

    ) {
        Text(text = "favorite Screen")

        person?.let {
            Text(text = person.name)
            Text(text = person.lastName)
        }

    }
}

