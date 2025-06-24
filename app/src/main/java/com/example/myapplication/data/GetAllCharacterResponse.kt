package com.example.myapplication.data

import kotlinx.serialization.Serializable

@Serializable
data class GetAllCharacterResponse(
    val info: ResponseInfo,
    val results: List<CharacterResponse>
)
@Serializable
data class ResponseInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
@Serializable
data class CharacterResponse(
    val id: Int,
    val name : String,
    val gender : String
)