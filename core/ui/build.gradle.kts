plugins {
    AndroidLibrary
    KotlinAndroid
    KotlinSymbolProcessing
    KotlinKapt
    Hilt
}

android {

    namespace = AppConfiguration.getNamespaceModule("core.ui")
    compileSdk = AppConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfiguration.MIN_SDK_VERSION
        testInstrumentationRunner = AppConfiguration.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = AppConfiguration.SOURCE_COMPATIBILITY
        targetCompatibility = AppConfiguration.TARGET_COMPATIBILITY
    }

    kotlinOptions {
        jvmTarget = AppConfiguration.JVM_TARGET
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.Versions.COMPILER
    }

}

dependencies {

    api(project(":core:model"))
    api(project(":core:resource"))

    implementationAndroidX()
    implementationCompose()
    implementationHilt()
    implementationLogs()
    implementationTest()

}