import org.gradle.api.JavaVersion

object AppConfiguration {

    const val NAMESPACE = "com.exchanger"
    const val APPLICATION_ID = "com.exchanger"
    const val COMPILE_SDK_VERSION = 34
    const val TARGET_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 24
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    // Compile options
    val SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
    val TARGET_COMPATIBILITY = JavaVersion.VERSION_17
    val JVM_TARGET = JavaVersion.VERSION_17.toString()

    fun getNamespaceModule(module: String): String {
        return "$NAMESPACE.$module"
    }

    object AppVersion {
        private const val MAJOR = 0
        private const val MINOR = 0 // Maximum value 99
        private const val PATCH = 1 // Maximum value 99

        fun getName(): String {
            return "$MAJOR.$MINOR.$PATCH"
        }

        fun getCode(): Int {
            return MAJOR * 10000 + MINOR * 100 + PATCH
        }
    }
}