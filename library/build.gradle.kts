plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinCocoapods)
    id("maven-publish")
    id("io.github.frankois944.spmForKmp") version "0.11.3"
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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.compilations {
            val main by getting {
                // Choose the cinterop name
                cinterops.create("nativeBridge")
            }
        }
    }

    swiftPackageConfig {
        create("nativeBridge") {
            minIos = "16.0"
            dependency {
                localPackage(
                    path = "$projectDir/../",
                    packageName = "MapboxCompose",
                    products = {
                        add("MapboxWrapper", exportToKotlin = true)
                    }
                )
//                remotePackageBranch(
//                    packageName = "MapboxCompose",
//                    url = uri("https://github.com/ghostship/MapboxCompose.git"),
//                    branch = "main",
//                    products = {
//                        add("MapboxWrapper", exportToKotlin = true)
//                    }
//                )
            }
        }
    }

//    cocoapods {
//        homepage = "MapboxMapView Library"
//        summary = "Crossplatform MapBox Map View Library"
//        version = "1.0"
//        ios.deploymentTarget = "16.0"
//
//        framework {
//            baseName = "composeApp"
//        }
//
//        pod("MapboxWrapper") {
//            version = "0.1.0"
//            extraOpts += listOf("-compiler-option", "-fmodules")
//            source = path(project.file("../MapboxWrapper"))
//        }
//    }

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

