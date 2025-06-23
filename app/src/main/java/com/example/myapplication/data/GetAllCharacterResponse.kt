package com.example.myapplication.data

data class GetAllCharacterResponse(
    val info: ResponseInfo,
    val results: List<CharacterResponse>
)

data class ResponseInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class CharacterResponse(
    val id: Int,
    val name : String,
    val gender : String
)