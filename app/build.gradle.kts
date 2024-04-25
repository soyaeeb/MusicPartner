plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.soyaeeb.musicpartner"
        minSdk = 21
        targetSdk =  33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        debug {
            getByName("debug"){
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
        release {
            getByName("release"){
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
    }
    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")

    // compose
    implementation ("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.animation:animation:1.4.0")
    implementation("androidx.compose.foundation:foundation:1.4.0")
    implementation("androidx.compose.runtime:runtime:1.4.0")
    implementation("androidx.compose.ui:ui:1.4.0")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")

    // compose preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")

    // Compose UI
    implementation("androidx.compose.ui:ui-tooling:1.4.0")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Compose viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // hilt dependencies
    implementation("com.google.dagger:hilt-android:2.45")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.core:core-ktx:1.9.0")
    kapt("com.google.dagger:hilt-android-compiler:2.45")


   // testing
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")



    // Media 3

    // For media playback using ExoPlayer
    implementation("androidx.media3:media3-exoplayer:1.0.0")

    // For DASH playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-dash:1.0.0")
    // For HLS playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-hls:1.0.0")
    // For RTSP playback support with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-rtsp:1.0.0")
    // For ad insertion using the Interactive Media Ads SDK with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-ima:1.0.0")

    // For loading data using the Cronet network stack
    implementation("androidx.media3:media3-datasource-cronet:1.0.0")
    // For loading data using the OkHttp network stack
    implementation("androidx.media3:media3-datasource-okhttp:1.0.0")
    // For loading data using librtmp
    implementation("androidx.media3:media3-datasource-rtmp:1.0.0")

    // For building media playback UIs
    implementation("androidx.media3:media3-ui:1.0.0")

    // For exposing and controlling media sessions
    implementation("androidx.media3:media3-session:1.0.0")

    // For extracting data from media containers
    implementation("androidx.media3:media3-extractor:1.0.0")

    // For integrating with Cast
    implementation("androidx.media3:media3-cast:1.0.0")

    // For scheduling background operations using Jetpack Work's WorkManager with ExoPlayer
    implementation("androidx.media3:media3-exoplayer-workmanager:1.0.0")

    // For transforming media files
    implementation("androidx.media3:media3-transformer:1.0.0")

    // Utilities for testing media components (including ExoPlayer components)
    implementation("androidx.media3:media3-test-utils:1.0.0")

    // Common functionality for media database components
    implementation("androidx.media3:media3-database:1.0.0")

    // Common functionality for media decoders
    implementation("androidx.media3:media3-decoder:1.0.0")

    // Common functionality for loading data
    implementation("androidx.media3:media3-datasource:1.0.0")

    // Common functionality used across multiple media libraries
    implementation("androidx.media3:media3-common:1.0.0")


    // jetpack runtime permission
    implementation("com.google.accompanist:accompanist-permissions:0.30.0")

    // Material 3
    implementation("androidx.compose.material3:material3:1.1.0-alpha08")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0-alpha08")

    // Material Extended icon
    implementation("androidx.compose.material:material-icons-extended:1.4.0-rc01")


    // Lottie Animation
    implementation ("com.airbnb.android:lottie-compose:6.0.0")

    // Status Bar Customization
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.30.0")

    // Module Dependency
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":cache"))
    implementation(project(":common"))
    implementation(project(":features:audiomusic"))
    implementation(project(":features:videomusic"))
    implementation(project(":features:youtube"))
    implementation(project(":features:chat"))
    implementation(project(":features:credential:login"))
    implementation(project(":features:credential:create-account"))
    implementation(project(":features:profile"))
    implementation(project(":features:settings"))
    implementation(project(":features:about"))
    implementation(project(":features:terms-conditions"))
    implementation(project(":helper"))
    implementation(project(":model"))
    implementation(project(":library"))
    implementation(project(":assets"))
}

kapt {
    correctErrorTypes = true
}

