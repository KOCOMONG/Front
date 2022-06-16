package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val apiBasicData= ApiBasicData.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getStringExtra("id")
        var name =intent.getStringExtra("name")
        var sex =""
        var age =""
        var height =""
        var weight =""
        var event =""
        var past =""
        var feminity =""
        apiBasicData.getBasicData(id).enqueue(object : Callback<BasicDataGetResult> {
            override fun onResponse(call: Call<BasicDataGetResult>, response: Response<BasicDataGetResult>) {
                var responseAPI = response.body()
                if (responseAPI != null) {
                    if(responseAPI.sex==0) {
                        sex = "남자"
                    }else if(responseAPI.sex==1) {
                        sex = "여자"
                    }
                    age= responseAPI.age
                    height= responseAPI.height
                    weight= responseAPI.weight
                    event= responseAPI.event
                    past= responseAPI.past
                    feminity= responseAPI.feminity
                }
            }
            override fun onFailure(call: Call<BasicDataGetResult>, t: Throwable) {
                // 실패
                Log.d("log",t.message.toString())
                Log.d("log","fail")
            }
        })
        Handler().postDelayed({
            binding.tv1Name.setText(name+"님 안녕하세요.")
            binding.tv1.setText("성별: "+sex)
            binding.tv2.setText("나이: "+age+"세")
            binding.tv3.setText("키: "+height+"cm")
            binding.tv4.setText("몸무게: "+weight+"kg")
            binding.tv5.setText("수술경력/입원여부:\n "+event)
            binding.tv6.setText("과거력:\n "+past)
            binding.tv7.setText("여성력:\n "+feminity)
        }, 3000)
        binding.btnStart3.setOnClickListener {
            val intent = Intent(this, BasicQuestionActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("name", name)
            intent.putExtra("key", "back")
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}
