package com.example.challengeideaboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Thread{
            Runnable {
                Thread.sleep(3000)
                runOnUiThread {
                    var iv_Loading = loadingConstraintLayout
                    iv_Loading?.visibility = View.GONE
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }.run()
        }.start()
    }
}
