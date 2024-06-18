package com.exchanger.data.di

import android.content.Context
import com.exchanger.data.local.database.ExchangerDatabase
import com.exchanger.data.local.database.dao.BalanceDao
import com.exchanger.data.util.ConstantsDatabase
import com.exchanger.database.util.DatabaseUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ExchangerDatabase {
        return DatabaseUtil.crateDatabase(
            context = context,
            klass = ExchangerDatabase::class.java,
            name = ConstantsDatabase.DATABASE_NAME,
            path = ConstantsDatabase.DATABASE_PATH
        )
    }

    @Provides
    @Singleton
    fun provideChannelDatabase(database: ExchangerDatabase): BalanceDao {
        return database.getBalance()
    }

}