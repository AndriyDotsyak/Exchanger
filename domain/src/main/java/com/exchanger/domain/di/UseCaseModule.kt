package com.exchanger.domain.di

import com.exchanger.domain.use_case.balance.get_balances.GetBalancesDefaultUseCase
import com.exchanger.domain.use_case.balance.get_balances.GetBalancesUseCase
import com.exchanger.domain.use_case.exchange.get_exchange_rates.GetExchangeRatesDefaultUseCase
import com.exchanger.domain.use_case.exchange.get_exchange_rates.GetExchangeRatesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetBalancesUseCase(useCase: GetBalancesDefaultUseCase): GetBalancesUseCase

    @Binds
    fun bindGetExchangeRatesUseCase(useCase: GetExchangeRatesDefaultUseCase): GetExchangeRatesUseCase
    
}