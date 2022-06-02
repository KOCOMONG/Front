package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityBasicQuestionBinding

class BasicQuestionActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityBasicQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBasicQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener {radioGroup, i ->
            when(i){
                R.id.radioButton -> println(1)
                R.id.radioButton2 -> println(2)
            }
        }
        binding.radioGroup.check(R.id.radioButton)

    }
    fun startSecondQuestion(v: View){
        val intent = Intent(this,SecondQuestionActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        finish()
    }

}