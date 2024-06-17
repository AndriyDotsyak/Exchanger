import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.PLUGIN_HILT_VERSION
    get() = "2.50"

inline val PluginDependenciesSpec.Hilt: PluginDependencySpec
    get() = id("com.google.dagger.hilt.android")