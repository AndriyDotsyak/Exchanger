package com.exchanger.data.source.exchange

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.exchanger.data.extension.get
import com.exchanger.data.extension.put
import com.exchanger.data.local.preferences.ExchangePreferences.FIELD_COUNT_EXCHANGE
import javax.inject.Inject

class ExchangeLocalDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    fun getExchangeCount(): Int {
        return dataStore.get(FIELD_COUNT_EXCHANGE, 0)
    }

    suspend fun setExchangeCount(count: Int) {
        dataStore.put(FIELD_COUNT_EXCHANGE, count)
    }

}