package com.example.myapplication.data.di

import com.example.myapplication.data.repository.GetAllCharactersImplementation
import com.example.myapplication.domain.repository.GetAllCharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindGetAllCharactersRepository(impl: GetAllCharactersImplementation): GetAllCharactersRepository
}