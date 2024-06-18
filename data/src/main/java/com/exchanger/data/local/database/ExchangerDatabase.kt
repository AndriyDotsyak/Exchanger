package com.exchanger.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exchanger.data.local.database.dao.BalanceDao
import com.exchanger.data.local.database.entity.BalanceEntity
import com.exchanger.data.util.ConstantsDatabase.DATABASE_VERSION

@Database(
    entities = [
        BalanceEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class ExchangerDatabase : RoomDatabase() {

    abstract fun getBalance(): BalanceDao

}