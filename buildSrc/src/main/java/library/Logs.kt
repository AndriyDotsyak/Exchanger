import extension.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Logs {

    private object Versions {
        const val TIMBER = "5.0.1"
    }

    internal const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
}

fun DependencyHandlerScope.implementationLogs() {
    implementation(Logs.TIMBER)
}
