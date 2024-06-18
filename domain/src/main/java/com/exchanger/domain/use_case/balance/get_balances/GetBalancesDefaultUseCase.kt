package com.exchanger.domain.use_case.balance.get_balances

import com.exchanger.data.repository.balance.BalanceRepository
import com.exchanger.model.balance.Balance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetBalancesDefaultUseCase @Inject constructor(
    private val balanceRepository: BalanceRepository
) : GetBalancesUseCase {

    override operator fun invoke(): List<Balance> {
        return emptyList()
    }

    override fun getStream(): Flow<List<Balance>> {
        return balanceRepository.getBalancesStream().map { balances ->
            balances.sorted()
        }
    }

    private fun List<Balance>.sorted(): List<Balance> {
        return sortedWith(
            compareByDescending<Balance> { it.balance }
                .thenBy { it.currency }
        )
    }
}