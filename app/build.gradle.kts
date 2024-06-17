plugins {
    AndroidApplication
    KotlinAndroid
    KotlinSymbolProcessing
    KotlinKapt
    Hilt
}

android {

    namespace = AppConfiguration.NAMESPACE
    compileSdk = AppConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AppConfiguration.APPLICATION_ID
        minSdk = AppConfiguration.MIN_SDK_VERSION
        targetSdk = AppConfiguration.TARGET_SDK_VERSION
        versionCode = AppConfiguration.AppVersion.getCode()
        versionName = AppConfiguration.AppVersion.getName()
        testInstrumentationRunner = AppConfiguration.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.Versions.COMPILER
    }

}

dependencies {

    implementation(project(":domain"))

    // Feature
    implementation(project(":feature:exchange"))

    // Core
    implementation(project(":core:ui"))

    implementationAndroidX()
    implementationCompose()
    implementationNavigation()
    implementationHilt()
    implementationLogs()
    implementationTest()

}