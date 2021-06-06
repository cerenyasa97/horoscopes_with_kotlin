package com.cerenyasa.horoscopes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.cerenyasa.horoscopes.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        window.statusBarColor = resources.getColor(R.color.status_bar_color)

        var returnLogo = AnimationUtils.loadAnimation(this, R.anim.return_logo)
        splashBinding.imageView2.animation = returnLogo
    }

    override fun onResume() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                var intent = Intent(this@Splash, MainActivity::class.java)
                startActivity(intent)
            }
        }.start()
        super.onResume()
    }
}