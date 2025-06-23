package com.example.myapplication.core.di

import com.example.myapplication.data.service.GetAllCharacterService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    fun provideJsonConverterFactory(json: Json): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    fun provideJsonNetwork(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @Provides
    fun provideRetrofit(
        baseUrl: String, jsonFactory: Converter.Factory
    ): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(jsonFactory).build()
        return retrofit
    }

    @Provides
    fun provideGetAllCharactersService(
        retrofit: Retrofit
    ): GetAllCharacterService {
        return retrofit.create(GetAllCharacterService::class.java)
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/"

    }
}