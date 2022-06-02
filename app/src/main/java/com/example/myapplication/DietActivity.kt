package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityDietBinding

class DietActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityDietBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDietBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton.setOnClickListener{
            dietResult(binding.root)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }


    private fun dietResult(v: View){
        val intent = Intent(this,DietResultActivity::class.java)
        intent.putExtra("period", binding.etPeriod.text.toString())
        intent.putExtra("weight", binding.etWeightGoal.text.toString())
        intent.putExtra("seekbar", binding.seekBar.progress.toString())

        startActivity(intent)
        finish()
    }

}