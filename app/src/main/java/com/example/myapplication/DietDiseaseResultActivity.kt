package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityDietDiseaseResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DietDiseaseResultActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityDietDiseaseResultBinding
    private val apiDiseaseDiet = ApiDiseaseDiet.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDietDiseaseResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getStringExtra("id")
        var practice = intent.getStringExtra("practice")
        var rice="밥"
        var soup="국"
        var sidedish="반찬"
        var salt ="1"
        var data = DiseaseDietPost(id,practice)
        apiDiseaseDiet.postDiseaseDiet(data).enqueue(object : Callback<DiseaseDietPostResult> {
            override fun onResponse(call: Call<DiseaseDietPostResult>, response: Response<DiseaseDietPostResult>) {
                var responseAPI = response.body()
                if (responseAPI != null) {
                    salt = responseAPI.salt.toString()
                    rice = responseAPI.rice
                    soup = responseAPI.soup
                    sidedish = responseAPI.sidedish
                }
            }
            override fun onFailure(call: Call<DiseaseDietPostResult>, t: Throwable) {
                // 실패
                Log.d("log",t.message.toString())
                Log.d("log","fail")
            }
        })
        Handler().postDelayed({
            binding.food1.setText(rice)
            binding.food2.setText(soup)
            binding.food3.setText(sidedish)
            if(salt=="1"){
                binding.imageViewSoup.setImageResource(R.drawable.fruit)
            }
            else{
                binding.imageViewSoup.setImageResource(R.drawable.soup)
            }
        }, 5000)
        binding.btnReset.setOnClickListener {
            data = DiseaseDietPost(id,practice)
            apiDiseaseDiet.postDiseaseDiet(data).enqueue(object : Callback<DiseaseDietPostResult> {
                override fun onResponse(call: Call<DiseaseDietPostResult>, response: Response<DiseaseDietPostResult>) {
                    var responseAPI = response.body()
                    if (responseAPI != null) {
                        salt = responseAPI.salt.toString()
                        rice = responseAPI.rice
                        soup = responseAPI.soup
                        sidedish = responseAPI.sidedish
                    }
                }
                override fun onFailure(call: Call<DiseaseDietPostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })
            Handler().postDelayed({
                binding.food1.setText(rice)
                binding.food2.setText(soup)
                binding.food3.setText(sidedish)
                if(salt=="1"){
                    binding.imageViewSoup.setImageResource(R.drawable.fruit)
                }
                else{
                    binding.imageViewSoup.setImageResource(R.drawable.soup)
                }
            }, 5000)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}