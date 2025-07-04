import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.loginEx"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.naverlogin"
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        properties.load(FileInputStream(rootProject.file("local.properties")))
        val kakaoNativeKey = properties["KAKAO_NATIVE_KEY"]
        manifestPlaceholders["kakaoScheme"] = "kakao$kakaoNativeKey"
        buildConfigField("String", "KAKAO_NATIVE_KEY", "\"$kakaoNativeKey\"")
        val naverClientId = properties["NAVER_CLIENT_ID"]
        buildConfigField("String", "NAVER_CLIENT_ID", "\"$naverClientId\"")
        val naverClientSecret = properties["NAVER_CLIENT_SECRET"]
        buildConfigField("String", "NAVER_CLIENT_SECRET", "\"$naverClientSecret\"")
        val naverClientName = properties["NAVER_CLIENT_NAME"]
        buildConfigField("String", "NAVER_CLIENT_NAME", "\"$naverClientName\"")
        val googleClientId = properties["GOOGLE_CLIENT_ID"]
        buildConfigField("String", "GOOGLE_CLIENT_ID", "\"$googleClientId\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // viewModel, livedata
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // naver login
    implementation(libs.oauth)

    // google firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)

    // google login
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.google.googleid)

    // coroutine
    implementation(libs.kotlinx.coroutines.core)

    // kakao SDK
    implementation(libs.v2.all)
}
