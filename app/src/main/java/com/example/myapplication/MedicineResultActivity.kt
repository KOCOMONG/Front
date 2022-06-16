package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMedicineResultBinding

class MedicineResultActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMedicineResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMedicineResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var data = intent.getStringExtra("data")
        binding.tvMedicineResult.setText(data)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}