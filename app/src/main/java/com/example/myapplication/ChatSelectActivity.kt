package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityChatSelectBinding

class ChatSelectActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityChatSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSymptom1.setOnClickListener{
            val intent = Intent(this,ChatResultActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSymptom2.setOnClickListener{
            val intent = Intent(this,ChatResultActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSymptom3.setOnClickListener{
            val intent = Intent(this,ChatResultActivity::class.java)
            startActivity(intent)
            finish()
        }

        var answer1 = intent.getStringExtra("answer1")

    }
    //뒤로가기
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }


}