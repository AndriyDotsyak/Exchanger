import extension.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Navigation {

    private object Versions {
        const val NAVIGATION = "2.7.6"
    }

    internal const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.NAVIGATION}"

}

fun DependencyHandlerScope.implementationNavigation() {
    implementation(Navigation.NAVIGATION)
}