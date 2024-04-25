import android.annotation.SuppressLint
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.soyaeeb.youtubestream"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose  = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    // core
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")

    // compose
    implementation ("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.animation:animation:1.4.0")
    implementation("androidx.compose.foundation:foundation:1.4.0")
    implementation("androidx.compose.runtime:runtime:1.4.0")
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.compose.ui:ui-tooling:1.4.0")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")


    // jetpack runtime permission
    implementation("com.google.accompanist:accompanist-permissions:0.30.0")

    // Material 3
    implementation("androidx.compose.material3:material3:1.1.0-alpha08")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0-alpha08")

    // Material Extended icon
    implementation("androidx.compose.material:material-icons-extended:1.4.0-rc01")


    // hilt dependencies
    implementation("com.google.dagger:hilt-android:2.45")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-android-compiler:2.45")

    // Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")


    // Google Play gms
    implementation(files("libs/YouTubeAndroidPlayerApi.jar"))
    //implementation(" androidx.fragment:fragment-ktx:1.5.5")

    implementation("com.google.android.gms:play-services-auth:20.4.1")
    implementation("com.google.api-client:google-api-client-android:2.2.0"){
        exclude(group = "org.apache.httpcomponents")
        exclude(group = "com.google.guava")
    }
    implementation("com.google.apis:google-api-services-youtube:v3-rev204-1.23.0"){
        exclude(group = "com.google.guava")
        exclude(group = "org.apache.httpcomponents")
    }

    // Module Dependency
    implementation(project(":assets"))
    implementation(project(":common"))
}
