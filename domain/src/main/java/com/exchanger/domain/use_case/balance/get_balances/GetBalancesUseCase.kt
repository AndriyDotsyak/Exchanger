package com.exchanger.domain.use_case.balance.get_balances

import com.exchanger.model.balance.Balance

interface GetBalancesUseCase {
    operator fun invoke(rates: Map<String, Double>): List<Balance>
}