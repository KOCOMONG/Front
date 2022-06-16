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
        var id = intent.getStringExtra("id")
        var cheifcomplaint = intent.getStringExtra("cheifcomplaint")
        var onset = intent.getStringExtra("onset")
        var location = intent.getStringExtra("location")
        var result1 = intent.getStringExtra("result1")
        var result2 = intent.getStringExtra("result2")
        var result3 = intent.getStringExtra("result3")
        binding.btnSymptom1.setText(result1)
        binding.btnSymptom2.setText(result2)
        binding.btnSymptom3.setText(result3)
        binding.btnSymptom1.setOnClickListener{
            val intent = Intent(this,ChatSecondActivity::class.java)
            intent.putExtra("id", id )
            intent.putExtra("cheifcomplaint", cheifcomplaint )
            intent.putExtra("onset", onset )
            intent.putExtra("location", location )
            intent.putExtra("level2_answer", result1 )
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
        binding.btnSymptom2.setOnClickListener{
            val intent = Intent(this,ChatSecondActivity::class.java)
            intent.putExtra("id", id )
            intent.putExtra("cheifcomplaint", cheifcomplaint )
            intent.putExtra("onset", onset )
            intent.putExtra("location", location )
            intent.putExtra("level2_answer", result2 )
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
        binding.btnSymptom3.setOnClickListener{
            val intent = Intent(this,ChatSecondActivity::class.java)
            intent.putExtra("id", id )
            intent.putExtra("cheifcomplaint", cheifcomplaint )
            intent.putExtra("onset", onset )
            intent.putExtra("location", location )
            intent.putExtra("level2_answer", result3 )
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
        var answer1 = intent.getStringExtra("answer1")
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}