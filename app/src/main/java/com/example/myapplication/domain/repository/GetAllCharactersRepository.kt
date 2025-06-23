package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.ResultPage
import kotlinx.coroutines.flow.Flow

interface GetAllCharactersRepository {

    suspend fun getAllCharacters(): Flow<Result<ResultPage>>
}