import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinComposePlugin)
    kotlin("native.cocoapods")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

kotlin {

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Kotlin Multiplatform Library"
        ios.deploymentTarget = "17.0"
        homepage = "https://github.com/akexorcist/compose-multiplatform"
        license = "Apache 2.0"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
        pod("iosPreviewView") {
            version = "0.1.0"
            source = path(project.file("../iosPreviewView"))
        }
        pod("GoogleMaps") {
            version = "9.0.0"
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.compose.runtime.livedata)
            implementation("androidx.camera:camera-camera2:1.3.3")
            implementation("androidx.camera:camera-lifecycle:1.3.3")
            implementation("androidx.camera:camera-view:1.3.3")
            implementation("com.markodevcic:peko:3.0.5")
            implementation("com.google.maps.android:maps-compose:5.0.1")
            implementation("io.ktor:ktor-client-android:2.3.11")
            implementation("io.github.kevinnzou:compose-webview-multiplatform:1.9.10")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.8.0")
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
            implementation("dev.snipme:highlights:0.9.0")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
            implementation("com.akexorcist.kotlin.multiplatform:dayandnight:1.0.0")
            implementation("media.kamel:kamel-image-default:1.0.0-beta.6")
            implementation("io.ktor:ktor-client-core:2.3.11")
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation("org.jetbrains.compose.ui:ui-tooling-preview-desktop:1.6.10")

            implementation("com.github.sarxos:webcam-capture:0.3.12")
            implementation("com.github.sarxos:webcam-capture-driver-openimaj:0.3.12")
            implementation("com.github.eduramiba:webcam-capture-driver-native:1.0.0")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.8.1")
            implementation("org.openstreetmap.jmapviewer:jmapviewer:2.16")
            implementation("io.ktor:ktor-client-cio:2.3.11")
            implementation("io.github.kevinnzou:compose-webview-multiplatform:1.9.10")
        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.11")
            implementation("io.github.kevinnzou:compose-webview-multiplatform:1.9.10")
        }
        jsMain.dependencies {
            implementation("io.ktor:ktor-client-js:2.3.11")
        }
        wasmJsMain.dependencies {
            implementation("io.ktor:ktor-client-core-wasm-js:3.0.0-beta-2-eap-941")
        }
    }
}

android {
    namespace = "com.akexorcist.kotlin.multiplatform"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.akexorcist.kotlin.multiplatform"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

secrets {
    propertiesFileName = "secrets.properties"
}

compose.desktop {
    application {
        mainClass = "com.akexorcist.kotlin.multiplatform.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.akexorcist.kotlin.multiplatform"
            packageVersion = "1.0.0"
            includeAllModules = true
        }

        buildTypes.release.proguard {
            configurationFiles.from("compose-desktop.pro")
        }
    }
}

javafx {
    version = "22"
    modules(
        "javafx.media",
    )
}

// Desktop Setup for Compose WebView Multiplatform
// https://github.com/KevinnZou/compose-webview-multiplatform/blob/main/README.desktop.md
afterEvaluate {
    tasks.withType<JavaExec> {
        jvmArgs("--add-opens", "java.desktop/sun.awt=ALL-UNNAMED")
        jvmArgs("--add-opens", "java.desktop/java.awt.peer=ALL-UNNAMED")

        if (System.getProperty("os.name").contains("Mac")) {
            jvmArgs("--add-opens", "java.desktop/sun.awt=ALL-UNNAMED")
            jvmArgs("--add-opens", "java.desktop/sun.lwawt=ALL-UNNAMED")
            jvmArgs("--add-opens", "java.desktop/sun.lwawt.macosx=ALL-UNNAMED")
        }
    }
}
