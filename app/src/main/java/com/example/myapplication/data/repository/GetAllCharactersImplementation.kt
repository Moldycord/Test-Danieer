package com.example.myapplication.data.repository

import com.example.myapplication.data.mapper.toDomain
import com.example.myapplication.data.service.GetAllCharacterService
import com.example.myapplication.domain.model.ResultPage
import com.example.myapplication.domain.repository.GetAllCharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllCharactersImplementation @Inject constructor(
    private val service: GetAllCharacterService
) : GetAllCharactersRepository {

    override suspend fun getAllCharacters() = flow<Result<ResultPage>> {
        try {
            val response = service.getAllCharacters().toDomain()
            emit(Result.success(response))
        } catch (error: Exception) {
            emit(Result.failure(error))
        }
    }.flowOn(Dispatchers.IO)
}