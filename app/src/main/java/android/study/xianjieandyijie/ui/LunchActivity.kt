package android.study.xianjieandyijie.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

/**
 *  Created by Zebra-RD张先杰 on 2022年9月16日11:17:26
 */
class LunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         installSplashScreen()
        if (!isTaskRoot) {
            finish();
            return;
        }
        startActivity(Intent(this@LunchActivity, MainActivity::class.java))
        finishAfterTransition()
    }
}