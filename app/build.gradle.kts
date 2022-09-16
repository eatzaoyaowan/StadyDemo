plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android-extensions")
}
//./gradlew assembleRelease
android {
    //关于版本问题 版本过低会出现功能不兼容或功能缺失(比如在Android12的开屏页) 由低升高又会出现一些兼容性问题(之前被弃用掉的权限请求莫名其妙的失效以及小米的Toast又莫名其妙的变成老版本的)
    //编译SDK版本
    ndkVersion = Config.Version.ndkVersion
    compileSdk = Config.Version.compileSdkVersion
    buildToolsVersion = Config.Version.buildToolsVersion
    defaultConfig {
        applicationId = Config.Version.applicationId
        //应用可运行的Android SDK最低版本，要大于所使用的所引用的的版本
        minSdk = Config.Version.minSdkVersion
        //目标SDK，用于选择某些新功能是否兼容 比如开屏页 如果低于31(Android 12) 它会在Android12上默认提供开屏页
        targetSdk = Config.Version.targetSdkVersion
        //它代表应用程序代码的相对版本 也就是版本更新过多少次 但是系统不会强制限制这个值
        versionCode = Config.Version.versionCode
        //它代表应用程序的版本信息，需要显示给用户
        versionName = Config.Version.versionName

        multiDexEnabled = false
        ndk {
            abiFilters.clear()
            abiFilters.addAll(Config.Build.ndkAbiFilters)
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        getByName("main").apply {
            jniLibs {
                srcDirs("libs")
            }
        }
    }

    signingConfigs {
        register("release") {
            keyAlias = Config.JKS.keyAlias
            keyPassword = Config.JKS.keyPassword
            storeFile = Config.JKS.storeFile
            storePassword = Config.JKS.storePassword
            enableV1Signing = true
            enableV2Signing = true
        }
    }

    buildTypes {
        getByName("release") {
            //混淆
            isMinifyEnabled = true
            // 移除无用的resource文件
            isShrinkResources = true

            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }

    android.applicationVariants.all {
        val buildType = this.preBuildProvider.name
        outputs.all {
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                this.outputFileName =
                    "${Config.Build.getPackedName()}_$buildType.apk"
            }
        }
    }
}

dependencies {
    implementation("androidx.core:core-splashscreen:1.0.0-rc01")
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.multidex:multidex:2.0.1")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}