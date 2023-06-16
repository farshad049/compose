package com.example.jetpackcompose.ui.navigation

const val DETAIL_SCREEN_KEY = "id"
const val DETAIL_SCREEN_KEY2 = "name"

const val SEARCH_SCREEN_KEY = "id"
const val SEARCH_SCREEN_KEY2 = "name"


sealed class Screens(val route: String){

    object Home: Screens(route = "home_screen")

    //the way to pass required arguments (without default value)
    object Detail: Screens(route = "detail_screen/{$DETAIL_SCREEN_KEY}/{$DETAIL_SCREEN_KEY2}"){
//        fun passId(id: Int): String{
//            return "detail_screen/$id"
//        }
        fun passNameAndId(id: Int,name: String):String{
            return "detail_screen/$id/$name"
        }
    }



    //the way to pass optional arguments (with default value)
    object Search: Screens(route = "search_screen?id={$SEARCH_SCREEN_KEY}&name={$SEARCH_SCREEN_KEY2}"){
//        fun passID(id: Int= 0): String{
//            return "search_screen?id=$id"
//        }
        fun passIDAndName(id: Int= 0, name: String= "farshad"):String{
            return "search_screen?id=$id&name=$name"
        }
    }


}
