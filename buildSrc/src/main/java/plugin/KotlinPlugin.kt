import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.PLUGIN_KOTLIN_VERSION
    get() = "1.9.22"

inline val PluginDependenciesSpec.KotlinAndroid: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.android")

inline val PluginDependenciesSpec.KotlinJVM: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.jvm")

inline val PluginDependenciesSpec.KotlinKapt: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.kapt")

inline val PluginDependenciesSpec.KotlinParcelize: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.plugin.parcelize")

inline val PluginDependenciesSpec.KotlinSerialization: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.plugin.serialization")