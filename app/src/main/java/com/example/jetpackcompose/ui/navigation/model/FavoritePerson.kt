package com.example.jetpackcompose.ui.navigation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class FavoritePerson (
    val name: String,
    val lastName: String
        ): Parcelable