package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityChatResultBinding

class ChatResultActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityChatResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    //뒤로가기
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }


}