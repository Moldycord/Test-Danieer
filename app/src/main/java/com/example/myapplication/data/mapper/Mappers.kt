package com.example.myapplication.data.mapper

import com.example.myapplication.data.GetAllCharacterResponse
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.model.ResultPage

fun GetAllCharacterResponse.toDomain(): ResultPage {
    return ResultPage(this.results.map { Character(it.name, it.gender) })
}