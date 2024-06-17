package com.exchanger.domain.use_case.balance.get_balances

import com.exchanger.model.balance.Balance
import javax.inject.Inject

class GetBalancesDefaultUseCase @Inject constructor() : GetBalancesUseCase {

    override operator fun invoke(rates: Map<String, Double>): List<Balance> {
        return rates.map { rate ->
            Balance(
                name = rate.key,
                amount = if (rate.key == DEFAULT_CURRENCY) {
                    DEFAULT_BALANCE
                } else 0.0
            )
        }.sorted()
    }

    private fun List<Balance>.sorted(): List<Balance> {
        return sortedWith(
            compareByDescending<Balance> { it.amount }
                .thenBy { it.name }
        )
    }

    companion object {
        private const val DEFAULT_CURRENCY = "EUR"
        private const val DEFAULT_BALANCE = 1_000.0
    }
}