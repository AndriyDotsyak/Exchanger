package com.exchanger.domain.use_case.exchange.get_exchange_rates

import com.exchanger.data.repository.exchange.ExchangeRepository
import com.exchanger.model.exchange.ExchangeRate
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetExchangeRatesDefaultUseCase @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : GetExchangeRatesUseCase {

    override suspend operator fun invoke(): ExchangeRate {
        return exchangeRepository.getExchangeRates()
    }

    override fun getStream() = flow {
        while (true) {
            delay(DELAY_UPDATE_RATE)
            emit(exchangeRepository.getExchangeRates())
        }
    }

    companion object {
        private const val DELAY_UPDATE_RATE = 5_000L
    }
}