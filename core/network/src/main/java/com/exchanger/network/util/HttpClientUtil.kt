package com.exchanger.network.util

import com.exchanger.network.extension.installHttpTimeout
import com.exchanger.network.extension.installJson
import com.exchanger.network.extension.installLogging
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType

object HttpClientUtil {

    fun getHttpClient(endpoint: String): HttpClient {
        return HttpClient(engineFactory = Android) {
            expectSuccess = true

            installJson()
            installHttpTimeout()
            installLogging()

            defaultRequest {
                accept(contentType = ContentType.Application.Json)

                url {
                    protocol = URLProtocol.HTTPS
                    host = endpoint
                }
            }
        }
    }
}
