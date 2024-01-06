plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coursework"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coursework"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
            isTestCoverageEnabled = true
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    dataBinding {
        enable = true
    }
}

val roomVer = "2.6.0"
dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    kapt("androidx.room:room-compiler:$roomVer")
    implementation("androidx.room:room-ktx:$roomVer")
    implementation("androidx.room:room-runtime:$roomVer")
    testImplementation("androidx.room:room-testing:$roomVer")

    //Data binding
    implementation("androidx.databinding:databinding-runtime:8.1.3")

    // Navigation
    implementation("androidx.navigation:navigation-ui:2.5.0")
    implementation("androidx.navigation:navigation-ui:2.5.0")

    implementation("androidx.navigation:navigation-fragment:2.5.0")

    // Koin
    implementation("io.insert-koin:koin-core:3.1.2")
    implementation("io.insert-koin:koin-android:3.1.2")

    // Koin for JUnit 4
    testImplementation("io.insert-koin:koin-test-junit4:3.1.2")

    //Hawk
    implementation("com.orhanobut:hawk:2.0.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.9.0")
    implementation("com.squareup.moshi:moshi-adapters:1.13.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
}