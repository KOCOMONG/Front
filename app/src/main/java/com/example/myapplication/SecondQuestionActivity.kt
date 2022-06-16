package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivitySecondQuestionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondQuestionActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySecondQuestionBinding
    private val apiBasicData = ApiBasicData.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var key = intent.getStringExtra("key")
        var id = intent.getStringExtra("id")
        var name =intent.getStringExtra("name")
        var sex = intent.getStringExtra("sex")
        var age = intent.getStringExtra("age")
        var height = intent.getStringExtra("height")
        var weight = intent.getStringExtra("weight")
        var event =""
        var past =""
        var feminity =""
        var result ="1"
        binding.btnNext.setOnClickListener {
            event = binding.etEvent.text.toString()
            past = binding.etPast.text.toString()
            feminity = binding.etFeminity.text.toString()
            val data = BasicDataPost(id,sex,age,height,weight,event,past,feminity)
            //통신
            apiBasicData.postBasicData(data).enqueue(object : Callback<BasicDataPostResult> {
                override fun onResponse(call: Call<BasicDataPostResult>, response: Response<BasicDataPostResult>) {
                    var responseAPI = response.body()
                    if (responseAPI != null) {
                        result = responseAPI.result.toString()
                    }
                }
                override fun onFailure(call: Call<BasicDataPostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })
            Handler().postDelayed({
                if(result=="1") {
                    if(key=="home") {
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("id", id)
                        intent.putExtra("name", name)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
                        finish()
                    }
                    else if(key=="back") {
                        overridePendingTransition(0, R.anim.slide_down_exit)
                        finish()
                    }
                }

            }, 3000)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}