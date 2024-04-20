plugins {
    alias(libs.plugins.androidApplication)
    /**
     * apply library after import in build gradle project,
     * add library realm database
     * its similiar to => apply plugin: 'realm-android'
     */
    id("realm-android")
}




android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)



    //import Extended Library
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.tbuonomo:dotsindicator:5.0")

    implementation("io.realm:realm-gradle-plugin:10.15.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
//    implementation ("de.mindconsulting.s3:jBCrypt:0.4") // jBCrypt library

    implementation("at.favre.lib:bcrypt:0.10.2")// jBCrypt library

}