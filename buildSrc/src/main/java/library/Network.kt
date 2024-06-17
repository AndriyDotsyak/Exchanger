import extension.api
import extension.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Network {

    private object Versions {
        const val KTOR = "2.3.8"
    }

    internal const val KTOR_CLIENT = "io.ktor:ktor-client-core:${Versions.KTOR}"
    internal const val KTOR_CLIENT_ANDROID = "io.ktor:ktor-client-android:${Versions.KTOR}"
    internal const val KTOR_CLIENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${Versions.KTOR}"
    internal const val KTOR_CLIENT_SERIALIZATION = "io.ktor:ktor-client-serialization:${Versions.KTOR}"
    internal const val KTOR_CLIENT_SERIALIZATION_JSON = "io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}"
    internal const val KTOR_CLIENT_LOGGING = "io.ktor:ktor-client-logging-jvm:${Versions.KTOR}"

}

fun DependencyHandlerScope.apiNetwork() {
    api(Network.KTOR_CLIENT)
    api(Network.KTOR_CLIENT_ANDROID)
    api(Network.KTOR_CLIENT_NEGOTIATION)
    api(Network.KTOR_CLIENT_SERIALIZATION)
    api(Network.KTOR_CLIENT_SERIALIZATION_JSON)
    api(Network.KTOR_CLIENT_LOGGING)
}

fun DependencyHandlerScope.implementationSerialization() {
    implementation(Network.KTOR_CLIENT_SERIALIZATION)
}