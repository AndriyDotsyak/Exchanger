import extension.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object AndroidX {

    private object Versions {
        const val CORE = "1.12.0"
        const val APPCOMPAT = "1.6.1"
        const val ACTIVITY = "1.8.2"
    }

    internal const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
    internal const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    internal const val ACTIVITY = "androidx.activity:activity-ktx:${Versions.ACTIVITY}"

}

fun DependencyHandlerScope.implementationAndroidX() {
    implementation(AndroidX.CORE)
    implementation(AndroidX.APPCOMPAT)
    implementation(AndroidX.ACTIVITY)
}