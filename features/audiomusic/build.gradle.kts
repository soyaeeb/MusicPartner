
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.soyaeeb.audiomusic"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            getByName("debug"){
                isMinifyEnabled = true
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

    buildFeatures {
        compose  = true
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
    implementation("androidx.core:core-ktx:1.9.0")
    kapt("com.google.dagger:hilt-android-compiler:2.45")


    // Compose coil for image loaging
    implementation("io.coil-kt:coil-compose:2.3.0")

    // Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    // Module Dependency
    implementation(project(":domain"))
    implementation(project(":model"))
    implementation(project(":assets"))
    implementation(project(":common"))
}