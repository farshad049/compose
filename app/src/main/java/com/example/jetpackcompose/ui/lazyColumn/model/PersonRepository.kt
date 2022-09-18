package com.example.jetpackcompose.ui.lazyColumn.model

class PersonRepository {
    fun getAllData(): List<PersonModel> {
        return listOf(
            PersonModel(
                id = 0,
                firstName = "John",
                lastName = "Doe",
                age = 20
            ),
            PersonModel(
                id = 1,
                firstName = "Maria",
                lastName = "Garcia",
                age = 21
            ),
            PersonModel(
                id = 2,
                firstName = "James",
                lastName = "Johnson",
                age = 22
            ),
            PersonModel(
                id = 3,
                firstName = "Michael",
                lastName = "Brown",
                age = 23
            ),
            PersonModel(
                id = 4,
                firstName = "Robert",
                lastName = "Davis",
                age = 24
            ),
            PersonModel(
                id = 5,
                firstName = "Jenifer",
                lastName = "Miller",
                age = 25
            ),
            PersonModel(
                id = 6,
                firstName = "Sarah",
                lastName = "Lopez",
                age = 26
            ),
            PersonModel(
                id = 7,
                firstName = "Charles",
                lastName = "Wilson",
                age = 27
            ),
            PersonModel(
                id = 8,
                firstName = "Daniel",
                lastName = "Taylor",
                age = 28
            ),
            PersonModel(
                id = 9,
                firstName = "Mark",
                lastName = "Lee",
                age = 29
            ),
        )
    }
}