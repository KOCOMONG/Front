package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivitySecondQuestionBinding

class SecondQuestionActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySecondQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    fun startHome(v: View){
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        finish()
    }

}