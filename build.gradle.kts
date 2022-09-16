// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Config.Version.gradleToolsVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
//        classpath("io.objectbox:objectbox-gradle-plugin:${Config.Version.objectBoxVersion}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
