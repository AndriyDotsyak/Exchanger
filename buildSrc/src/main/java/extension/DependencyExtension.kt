package extension

import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementation(dependencyNotation: Any): Dependency? {
    return add("implementation", dependencyNotation)
}

internal fun DependencyHandlerScope.api(dependencyNotation: Any): Dependency? {
    return add("api", dependencyNotation)
}

internal fun DependencyHandlerScope.debugImplementation(dependencyNotation: Any): Dependency? {
    return add("debugImplementation", dependencyNotation)
}

internal fun DependencyHandlerScope.androidTestImplementation(dependencyNotation: Any): Dependency? {
    return add("androidTestImplementation", dependencyNotation)
}

internal fun DependencyHandlerScope.testImplementation(dependencyNotation: Any): Dependency? {
    return add("testImplementation", dependencyNotation)
}

internal fun DependencyHandlerScope.ksp(dependencyNotation: Any): Dependency? {
    return add("ksp", dependencyNotation)
}

internal fun DependencyHandlerScope.kapt(dependencyNotation: Any): Dependency? {
    return add("kapt", dependencyNotation)
}