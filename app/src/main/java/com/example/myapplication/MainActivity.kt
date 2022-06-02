package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 1500 // 0.5 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, LoginActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)


    }



//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                val intent = Intent(this,LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//            MotionEvent.ACTION_MOVE -> {
//            }
//            MotionEvent.ACTION_UP -> {
//            }
//            MotionEvent.ACTION_CANCEL -> {
//            }
//            else -> {
//            }
//        }
//        return true
//    }
}