import extension.androidTestImplementation
import extension.testImplementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Test {

    private object Versions {
        const val JUNIT = "4.13.2"
        const val JUNIT_EXTENSIVE = "1.1.5"
        const val ESPRESSO = "3.5.1"
    }

    internal const val JUNIT = "junit:junit:${Versions.JUNIT}"
    internal const val JUNIT_EXTENSIVE = "androidx.test.ext:junit:${Versions.JUNIT_EXTENSIVE}"
    internal const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

}

fun DependencyHandlerScope.implementationTest() {
    testImplementation(Test.JUNIT)
    androidTestImplementation(Test.JUNIT_EXTENSIVE)
    androidTestImplementation(Test.ESPRESSO)
}