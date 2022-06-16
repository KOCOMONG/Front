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
        var id = intent.getStringExtra("id")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")
        var sex ="" // 남자0, 여자1
        var age =""
        var height =""
        var weight =""
        binding.btnNext.setOnClickListener {
            if (binding.radioButton.isChecked)
                sex="0"
            else
                sex="1"
            age = binding.etAge.text.toString()
            height = binding.etHeight.text.toString()
            weight = binding.etWeight.text.toString()

            val intent = Intent(this,SecondQuestionActivity::class.java)
            intent.putExtra("key", key)
            intent.putExtra("id", id)
            intent.putExtra("name", name)
            intent.putExtra("sex", sex)
            intent.putExtra("age", age)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
        binding.radioGroup.setOnCheckedChangeListener {radioGroup, i ->
            when(i){
                R.id.radioButton -> println(1)
                R.id.radioButton2 -> println(2)
            }
        }
        binding.radioGroup.check(R.id.radioButton)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}