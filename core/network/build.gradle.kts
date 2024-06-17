plugins {
    AndroidLibrary
    KotlinAndroid
    KotlinKapt
    Hilt
}

android {

    namespace = AppConfiguration.getNamespaceModule("core.network")
    compileSdk = AppConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfiguration.MIN_SDK_VERSION
        testInstrumentationRunner = AppConfiguration.TEST_INSTRUMENTATION_RUNNER

        buildConfigField("String", "ENDPOINT", "\"developers.paysera.com\"")
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

    apiNetwork()
    implementationHilt()
    implementationLogs()
    implementationTest()

}