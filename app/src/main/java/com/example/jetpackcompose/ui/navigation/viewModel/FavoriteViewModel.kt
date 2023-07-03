package com.example.jetpackcompose.ui.navigation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.ui.lazyColumn.model.PersonModel
import com.example.jetpackcompose.ui.navigation.model.FavoritePerson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(): ViewModel() {

    var person by mutableStateOf<FavoritePerson?>(null)
        private set

    fun addPerson(newPerson: FavoritePerson){
        person= newPerson
    }

}