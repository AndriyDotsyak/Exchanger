import extension.debugImplementation
import extension.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Compose {

    object Versions {
        internal const val COMPOSE = "1.6.0"
        internal const val MATERIAL = "1.2.1"
        internal const val ACTIVITY = "1.8.2"
        internal const val LIFECYCLE = "2.7.0"
        internal const val CONSTRAINT_LAYOUT = "1.0.1"
        const val COMPILER = "1.5.8"
    }

    internal const val MATERIAL = "androidx.compose.material3:material3:${Versions.MATERIAL}"
    internal const val ANIMATION = "androidx.compose.animation:animation:${Versions.COMPOSE}"
    internal const val UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    internal const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    internal const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    internal const val LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}"
    internal const val ACTIVITY = "androidx.activity:activity-compose:${Versions.ACTIVITY}"
    internal const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"
    internal const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.LIFECYCLE}"
    internal const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:${Versions.CONSTRAINT_LAYOUT}"

}

fun DependencyHandlerScope.implementationCompose() {
    implementation(Compose.MATERIAL)
    implementation(Compose.ANIMATION)
    implementation(Compose.UI)
    implementation(Compose.UI_TOOLING_PREVIEW)
    debugImplementation(Compose.UI_TOOLING)
    implementation(Compose.LIVEDATA)
    implementation(Compose.ACTIVITY)
    implementation(Compose.LIFECYCLE_VIEW_MODEL)
    implementation(Compose.LIFECYCLE_RUNTIME)
    implementation(Compose.CONSTRAINT_LAYOUT)
}