package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityDietResultBinding

class DietResultActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityDietResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDietResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weight = intent.getStringExtra("weight")
        val period = intent.getStringExtra("period")
        val seekbar = intent.getStringExtra("seekbar")

        binding.tvTest.setText(weight+period+seekbar)


    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }




}