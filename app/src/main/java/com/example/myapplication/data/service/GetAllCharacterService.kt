package com.example.myapplication.data.service

import com.example.myapplication.data.GetAllCharacterResponse
import retrofit2.http.GET


interface GetAllCharacterService {

    @GET("api/character")
    suspend fun getAllCharacters(): GetAllCharacterResponse
}