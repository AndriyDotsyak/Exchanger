import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.PLUGIN_ANDROID_VERSION
    get() = "8.2.2"

inline val PluginDependenciesSpec.AndroidApplication: PluginDependencySpec
    get() = id("com.android.application")

inline val PluginDependenciesSpec.AndroidLibrary: PluginDependencySpec
    get() = id("com.android.library")