package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.ResultPage
import com.example.myapplication.domain.repository.GetAllCharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repository: GetAllCharactersRepository
) {

    suspend operator fun invoke(): Flow<Result<ResultPage>> {
        return repository.getAllCharacters()
    }
}