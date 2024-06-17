import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.PLUGIN_KSP_VERSION
    get() = "1.9.22-1.0.17"

inline val PluginDependenciesSpec.KotlinSymbolProcessing: PluginDependencySpec
    get() =  id("com.google.devtools.ksp")