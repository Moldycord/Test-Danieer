package com.example.myapplication.domain.model


data class ResultPage(
    val characters: List<Character>
)

data class Character(
    val name: String,
    val gender: String
)