package com.example.myapplication.domain.model

sealed class ApiResult<out T> {
    data object Loading : ApiResult<Nothing>()
    //data class Data(val data: ApiResult<out T>) : ApiResult<out T>()
    data class Error(val errorMessage: String, val cause : Error): ApiResult<Nothing>()
}