package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMedicine2Binding

class Medicine2Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  binding: ActivityMedicine2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMedicine2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val medicineName = intent.getStringExtra("medicineName")
        binding.etMedicineName.setText(medicineName)

        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }

    override fun onClick(view: View?)
    {
        when ( view!!.id)
        {
            R.id.button->
            {
                medicineResult(view)
            }
            R.id.button2->
            {
                medicineResult(view)
            }
            R.id.button3->
            {
                medicineResult(view)
            }
            R.id.button4->
            {
                medicineResult(view)
            }
            R.id.button5->
            {
                medicineResult(view)
            }
        }
    }
    private fun medicineResult(v:View){
        val intent = Intent(this,MedicineResultActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        finish()
    }


}


