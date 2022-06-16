package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityDietResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DietResultActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityDietResultBinding
    private val apiDiet = ApiDiet.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDietResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getStringExtra("id")
        var want_weight= intent.getStringExtra("want_weight")
        var want_time = intent.getStringExtra("want_time")
        var practice = intent.getStringExtra("practice")
        var rice="밥"
        var soup="국"
        var sidedish="반찬"
        var food_cal=""
        var practice_cal=""
        var data = DietPost(id,want_weight,want_time,practice)
        apiDiet.postDiet(data).enqueue(object : Callback<DietPostResult> {
            override fun onResponse(call: Call<DietPostResult>, response: Response<DietPostResult>) {
                var responseAPI = response.body()
                if (responseAPI != null) {
                    rice = responseAPI.rice
                    soup = responseAPI.soup
                    sidedish = responseAPI.sidedish
                    food_cal= responseAPI.food_cal
                    practice_cal= responseAPI.practice_cal
                }
            }
            override fun onFailure(call: Call<DietPostResult>, t: Throwable) {
                // 실패
                Log.d("log",t.message.toString())
                Log.d("log","fail")
            }
        })
        Handler().postDelayed({
            binding.food1.setText(rice)
            binding.food2.setText(soup)
            binding.food3.setText(sidedish)
            binding.textView6.setText("식사 조절로 줄여야 할 칼로리 : "+food_cal+"kcal")
            binding.textView7.setText("운동으로 소모해야 할 칼로리 : "+practice_cal+"kcal")
        }, 5000)
        binding.btnReset.setOnClickListener {
            //통신
            data = DietPost(id,want_weight,want_time,practice)
            apiDiet.postDiet(data).enqueue(object : Callback<DietPostResult> {
                override fun onResponse(call: Call<DietPostResult>, response: Response<DietPostResult>) {
                    var responseAPI = response.body()
                    if (responseAPI != null) {
                        rice = responseAPI.rice
                        soup = responseAPI.soup
                        sidedish = responseAPI.sidedish
                        food_cal= responseAPI.food_cal
                        practice_cal= responseAPI.practice_cal
                    }
                }
                override fun onFailure(call: Call<DietPostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })
            Handler().postDelayed({
                binding.food1.setText(rice)
                binding.food2.setText(soup)
                binding.food3.setText(sidedish)
                binding.textView6.setText("식사 조절로 줄여야 할 칼로리 : "+food_cal+"kcal")
                binding.textView7.setText("운동으로 소모해야 할 칼로리 : "+practice_cal+"kcal")
            }, 5000)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}