plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinCocoapods)
    id("maven-publish")
    id("io.github.ttypic.swiftklib") version "0.6.4"
}

group = "com.inspiringapps.libs"
version = "1.0"

publishing {
    repositories {
        maven {
            name = "mavenLocal"
        }
    }
}

kotlin {
    androidLibrary {
        namespace = "com.inspiringapps.libs.mapboxcompose"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withHostTestBuilder {}

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        homepage = "MapboxMapView Library"
        summary = "Crossplatform MapBox Map View Library"
        version = "1.0"
        ios.deploymentTarget = "16.0"

        framework {
            baseName = "composeApp"
        }

        pod("MapboxWrapper") {
            version = "0.1.0"
            extraOpts += listOf("-compiler-option", "-fmodules")
            source = path(project.file("../MapboxWrapper"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                implementation(compose.preview)
                implementation(libs.mapbox.android)
                implementation(libs.mapbox.compose)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {}
        }
    }
}

