import extension.implementation
import extension.kapt
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Hilt {

    private object Versions {
        const val HILT = "2.50"
        const val NAVIGATION_COMPOSE = "1.1.0"
    }

    internal const val ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    internal const val NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.NAVIGATION_COMPOSE}"
    internal const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

}

fun DependencyHandlerScope.implementationHilt() {
    implementation(Hilt.ANDROID)
    implementation(Hilt.NAVIGATION_COMPOSE)
    kapt(Hilt.ANDROID_COMPILER)
}