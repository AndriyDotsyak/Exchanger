package com.exchanger.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.exchanger.data.local.database.entity.BalanceEntity
import com.exchanger.data.util.ConstantsDatabase.Balance
import com.exchanger.data.util.ConstantsDatabase.Balance.Fields
import com.exchanger.database.BaseDatabase
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BalanceDao : BaseDatabase<BalanceEntity>(Balance.TABLE_NAME) {

    @Query("SELECT * FROM ${Balance.TABLE_NAME}")
    abstract fun getBalancesStream(): Flow<List<BalanceEntity>>

    @Query("SELECT * FROM ${Balance.TABLE_NAME} WHERE ${Fields.CURRENCY}=:currency")
    abstract fun getBalance(currency: String): BalanceEntity?

    @Query("UPDATE ${Balance.TABLE_NAME} SET ${Fields.BALANCE}=:balance WHERE ${Fields.CURRENCY}=:currency")
    abstract fun updateBalance(currency: String, balance: Double)

}