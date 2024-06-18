package com.exchanger.data.mapper

import com.exchanger.data.local.database.entity.BalanceEntity
import com.exchanger.model.balance.Balance

object BalanceMapper {

    fun mapToDto(balances: List<BalanceEntity>): List<Balance> {
        return balances.map { mapToDto(it) }
    }

    fun mapToDto(balance: BalanceEntity): Balance {
        return Balance(
            currency = balance.currency,
            balance = balance.balance
        )
    }

    fun mapToEntity(balances: List<Balance>): List<BalanceEntity> {
        return balances.map { mapToEntity(it) }
    }

    fun mapToEntity(balance: Balance): BalanceEntity {
        return BalanceEntity(
            currency = balance.currency,
            balance = balance.balance
        )
    }

}