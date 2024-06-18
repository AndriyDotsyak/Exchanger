package com.exchanger.data.local.preferences

import androidx.datastore.preferences.core.intPreferencesKey

object ExchangePreferences {

    private const val KEY_COUNT_EXCHANGE = "count_exchange"
    val FIELD_COUNT_EXCHANGE = intPreferencesKey(KEY_COUNT_EXCHANGE)

}