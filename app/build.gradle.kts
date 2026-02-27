plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.apipracticeapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.apipracticeapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.compose.ui)
        implementation(libs.androidx.compose.ui.graphics)
        implementation(libs.androidx.compose.ui.tooling.preview)
        implementation(libs.androidx.compose.material3)

        implementation("com.google.dagger:hilt-android:2.50")
        kapt("com.google.dagger:hilt-compiler:2.50")

        // Networking
        implementation("com.squareup.retrofit2:retrofit:2.11.0")
        implementation("com.squareup.retrofit2:converter-gson:2.11.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

        // Lifecycle + Coroutines
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

        // Navigation
        implementation("androidx.navigation:navigation-compose:2.8.5")

        // Hilt compose
        implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

        // Image loading
        implementation("io.coil-kt:coil-compose:2.7.0")

        // Tests
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
        testImplementation("io.mockk:mockk:1.13.8")
        testImplementation("junit:junit:4.13.2")
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
