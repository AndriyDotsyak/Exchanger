plugins {
    AndroidLibrary
    KotlinAndroid
    KotlinKapt
    KotlinParcelize
    KotlinSerialization
}

android {

    namespace = AppConfiguration.getNamespaceModule("core.model")
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

}

dependencies {

    implementation(project(":core:resource"))

    implementationAndroidX()
    implementationSerialization()
    implementationTest()

}