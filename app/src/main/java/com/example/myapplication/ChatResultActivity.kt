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
        var name1 = intent.getStringExtra("name1")
        var name2 = intent.getStringExtra("name2")
        var name3 = intent.getStringExtra("name3")
        var percent1 = intent.getStringExtra("percent1")
        var percent2 = intent.getStringExtra("percent2")
        var percent3 = intent.getStringExtra("percent3")
        var synonym1 = intent.getStringExtra("synonym1")
        var synonym2 = intent.getStringExtra("synonym2")
        var synonym3 = intent.getStringExtra("synonym3")
        var department1 = intent.getStringExtra("department1")
        var department2 = intent.getStringExtra("department2")
        var department3 = intent.getStringExtra("department3")
        var explain1 = intent.getStringExtra("explain1")
        var explain2 = intent.getStringExtra("explain2")
        var explain3 = intent.getStringExtra("explain3")
        binding.tv1Name.setText("Top 1."+name1+"  "+percent1+"%")
        binding.tv2Name.setText("Top 2."+name2+"  "+percent2+"%")
        binding.tv3Name.setText("Top 3."+name3+"  "+percent3+"%")
        binding.tv1Synonym.setText("동의어: "+synonym1)
        binding.tv2Synonym.setText("동의어: "+synonym2)
        binding.tv3Synonym.setText("동의어: "+synonym3)
        binding.tv1Department.setText("진료과: "+department1)
        binding.tv2Department.setText("진료과: "+department2)
        binding.tv3Department.setText("진료과: "+department3)
        binding.tv1Explain.setText(explain1)
        binding.tv2Explain.setText(explain2)
        binding.tv3Explain.setText(explain3)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}