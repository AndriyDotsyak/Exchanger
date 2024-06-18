package com.exchanger.data.source.balance

import com.exchanger.data.local.database.dao.BalanceDao
import com.exchanger.data.local.database.entity.BalanceEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BalanceLocalDataSource @Inject constructor(
    private val database: BalanceDao
) {

    fun getBalances(): List<BalanceEntity> {
        return database.getAll()
    }

    fun getBalancesStream(): Flow<List<BalanceEntity>> {
        return database.getBalancesStream()
    }

    fun getBalance(currency: String): BalanceEntity? {
        return database.getBalance(currency)
    }

    fun updateBalance(currency: String, balance: Double) {
        database.updateBalance(currency, balance)
    }

}