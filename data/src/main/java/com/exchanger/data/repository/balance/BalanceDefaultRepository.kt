package com.exchanger.data.repository.balance

import com.exchanger.data.mapper.BalanceMapper
import com.exchanger.data.source.balance.BalanceLocalDataSource
import com.exchanger.model.balance.Balance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BalanceDefaultRepository @Inject constructor(
    private val localSource: BalanceLocalDataSource
) : BalanceRepository {
    override fun getBalances(): List<Balance> {
        return BalanceMapper.mapToDto(localSource.getBalances())
    }

    override fun getBalancesStream(): Flow<List<Balance>> {
        return localSource.getBalancesStream().map { balances ->
            BalanceMapper.mapToDto(balances)
        }
    }

    override fun getBalance(currency: String): Balance? {
        return localSource.getBalance(currency)?.let { balance ->
            BalanceMapper.mapToDto(balance)
        }
    }

    override fun updateBalance(currency: String, balance: Double) {
        localSource.updateBalance(currency, balance)
    }

}