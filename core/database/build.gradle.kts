plugins {
    AndroidLibrary
    KotlinAndroid
    KotlinKapt
    KotlinSymbolProcessing
}

android {

    namespace = AppConfiguration.getNamespaceModule("core.database")
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
        buildConfig = true
    }

}

dependencies {

    implementationDatabase()
    implementationTest()

}