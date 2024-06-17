package com.exchanger.domain.use_case.exchange.get_exchange_rates

import com.exchanger.data.repository.exchange.ExchangeRepository
import com.exchanger.model.exchange.ExchangeRate
import javax.inject.Inject

class GetExchangeRatesDefaultUseCase @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : GetExchangeRatesUseCase {

    override suspend operator fun invoke(): ExchangeRate {
        return exchangeRepository.getExchangeRates()
    }

}