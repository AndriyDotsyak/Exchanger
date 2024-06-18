package com.exchanger.data.di

import com.exchanger.data.repository.balance.BalanceDefaultRepository
import com.exchanger.data.repository.balance.BalanceRepository
import com.exchanger.data.repository.exchange.ExchangeDefaultRepository
import com.exchanger.data.repository.exchange.ExchangeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindBalanceRepository(repository: BalanceDefaultRepository): BalanceRepository

    @Binds
    fun bindExchangeRepository(repository: ExchangeDefaultRepository): ExchangeRepository

}