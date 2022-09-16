import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/**
Created by Zebra-RD张先杰 on 2022年9月16日10:10:13

Description:
 */
object Config {
    object Version{
        //依赖版本
        const val compileSdkVersion = 31
        //最小支持SDK
        const val minSdkVersion = 23
        //当前基于SDK
        const val targetSdkVersion = 31
        //Build Tools Version
        const val buildToolsVersion = "30.0.3"
        //NDK Version
        const val ndkVersion = "21.4.7075529"

        //Packed Name
        const val applicationId = "android.study.xianjieandyijie"
        //Version Code
        const val versionCode = 1
        //Version Name
        const val versionName = "1.0.0"
        //Gradle Tools Version
        const val gradleToolsVersion = "7.2.1"
        //Kotlin Version
        const val kotlinVersion = "1.7.10"
    }

    object JKS{
        const val keyAlias = ""
        const val keyPassword = ""
        const val storePassword = ""
        val storeFile =
            File("D:/JKS/app_signer.jks")
//        "D:/experienceCloud/app-signer.jks"
    }

    object Build{
        //"armeabi","armeabi-v7a" ,"x86", "x86_64",
        var ndkAbiFilters = mutableSetOf<String>("armeabi-v7a","arm64-v8a")
        //Apk Name
        fun getPackedName(): String {
            return "v${Version.versionName}_${SimpleDateFormat("MM.dd").format(Date(System.currentTimeMillis()))}"
        }
    }
}