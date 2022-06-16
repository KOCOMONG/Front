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
        var want_weight =""
        var want_time=""
        var practice=""
        var id = intent.getStringExtra("id")
        binding.btnDietStart.setOnClickListener{
            practice=(binding.seekBar.progress+1).toString()
            val intent = Intent(this,DietDiseaseResultActivity::class.java)
            intent.putExtra("id", id )
            intent.putExtra("practice", practice)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
        binding.btnDietStart2.setOnClickListener{
            practice=(binding.seekBar.progress+1).toString()
            want_weight=binding.etWeightGoal1.text.toString()
            want_time=binding.etPeriod1.text.toString()
            val intent = Intent(this,DietResultActivity::class.java)
            intent.putExtra("id", id )
            intent.putExtra("practice", practice)
            intent.putExtra("want_weight", want_weight )
            intent.putExtra("want_time", want_time )
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}