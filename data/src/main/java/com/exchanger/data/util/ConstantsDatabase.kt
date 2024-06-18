package com.exchanger.data.util

object ConstantsDatabase {

    const val DATABASE_NAME = "Exchanger"
    const val DATABASE_PATH = "database/Exchanger.db"
    const val DATABASE_VERSION = 1

    object Balance {

        const val TABLE_NAME = "Balance"

        object Fields {
            const val CURRENCY = "currency"
            const val BALANCE = "balance"
        }
    }

}