package com.exchanger.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exchanger.data.util.ConstantsDatabase.Balance
import com.exchanger.data.util.ConstantsDatabase.Balance.Fields

@Entity(tableName = Balance.TABLE_NAME)
data class BalanceEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(Fields.CURRENCY)
    val currency: String = String(),

    @ColumnInfo(Fields.BALANCE)
    val balance: Double = 0.0

)