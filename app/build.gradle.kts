plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("com.apollographql.apollo3").version("3.7.3")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
apollo {
    service("service") {
        packageName.set("com.example")
        // Define the location where Apollo should download the schema
//        schema.set(file("src/main/graphql/schema.graphqls"))
        schemaFile.set(file("src/main/graphql/schema.graphqls"))
//        schemaFile = file("app/src/main/graphql/schema.graphqls")
        // Specify the GraphQL endpoint
        introspection {
            endpointUrl.set("https://countries.trevorblades.com/graphql")
//            endpointUrl = "https://countries.trevorblades.com/graphql"
//            endpoint.set("https://countries.trevorblades.com/graphql")
        }
    }
}

android {
    namespace = "com.example.graphql"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.graphql"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //
    implementation("com.apollographql.apollo3:apollo-runtime:3.7.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}