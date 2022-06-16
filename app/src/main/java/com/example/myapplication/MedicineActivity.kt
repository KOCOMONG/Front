package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMedicineBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicineActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  binding: ActivityMedicineBinding
    private val apiMedicine = ApiMedicine.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
    override fun onClick(view: View?)
    {
        when ( view!!.id)
        {
            R.id.btn_1->
            {
                var tool = "keep"
                medicineResult(view,tool)
            }
            R.id.btn_2->
            {
                var tool = "effect"
                medicineResult(view,tool)
            }
            R.id.btn_3->
            {
                var tool = "usage"
                medicineResult(view,tool)
            }
            R.id.btn_4->
            {
                var tool = "caution"
                medicineResult(view,tool)
            }
            R.id.btn_5->
            {
                var tool = "information"
                medicineResult(view,tool)
            }
        }
    }
    private fun medicineResult(v:View, tool:String){
        var medicineName = binding.etAnswer.text.toString()
        var medicineData="해당 의약품을 찾을 수 없습니다.\n약품명을 확인해주세요."
        //통신
        apiMedicine.getMedicine(medicineName,tool).enqueue(object : Callback<MedicineGetResult> {
            override fun onResponse(call: Call<MedicineGetResult>, response: Response<MedicineGetResult>) {
                var responseAPI = response.body()
                if (responseAPI != null) {
                    medicineData = responseAPI.data
                }
            }
            override fun onFailure(call: Call<MedicineGetResult>, t: Throwable) {
                // 실패
                Log.d("log",t.message.toString())
                Log.d("log","fail")
            }
        })
        Handler().postDelayed({
            if(medicineData=="no data"){
                var dialog = AlertDialog.Builder(this@MedicineActivity)
                dialog.setTitle("알림")
                dialog.setMessage("해당 의약품을 찾을 수 없습니다.\n 약품명을 확인해주세요.")
                dialog.show()
            }
            else{
                val intent = Intent(this,MedicineResultActivity::class.java)
                intent.putExtra("data", medicineData)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
                finish()
            }
        }, 2000)
    }
}