package com.exchanger.data.di

import com.exchanger.data.repository.exchange.DefaultExchangeRepository
import com.exchanger.data.repository.exchange.ExchangeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindExchangeRepository(repository: DefaultExchangeRepository): ExchangeRepository

}