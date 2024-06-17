package com.exchanger.network.di

import com.exchanger.core.network.BuildConfig
import com.exchanger.network.util.HttpClientUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientUtil.getHttpClient(
            endpoint = BuildConfig.ENDPOINT
        )
    }

}
