plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.exemplo.meudinheiro"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.exemplo.meudinheiro"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
