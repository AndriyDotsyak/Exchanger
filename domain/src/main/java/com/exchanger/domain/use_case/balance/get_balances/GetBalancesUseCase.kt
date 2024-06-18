package com.exchanger.domain.use_case.balance.get_balances

import com.exchanger.model.balance.Balance
import kotlinx.coroutines.flow.Flow

interface GetBalancesUseCase {
    operator fun invoke(): List<Balance>
    fun getStream(): Flow<List<Balance>>
}