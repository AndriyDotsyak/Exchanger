package com.exchanger.data.repository.balance

import com.exchanger.model.balance.Balance
import kotlinx.coroutines.flow.Flow

interface BalanceRepository {
    fun getBalances(): List<Balance>
    fun getBalancesStream(): Flow<List<Balance>>
    fun getBalance(currency: String): Balance?
    fun updateBalance(currency: String, balance: Double)
}