package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityChatBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityChatBinding
    private val apiDisease = ApiDisease.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getStringExtra("id")
        var cheifcomplaint= ""
        var onset= ""
        var location= ""
        var result1=""
        var result2=""
        var result3=""
        var tmp:Int = 0
        var max:Int = 2
        val questionList: List<String> = listOf(
            "어떤 증상이 있으신가요?",
            "언제부터 증상이 시작되었나요?",
            "어디가 불편한가요?( 위 아래 옆구리 등 )"
        )
        var answerList= mutableListOf<String>()
        binding.imageButton.setOnClickListener{
            if(tmp<max) {
                binding.tvQuestion.text = questionList.get(++tmp)
                answerList.add(binding.etAnswer.text.toString())
                binding.etAnswer.setText("")
            }
            else{
                answerList.add(binding.etAnswer.text.toString())
                cheifcomplaint = answerList[0]
                onset = answerList[1]
                location = answerList[2]
                val data = DiseasePost(id,cheifcomplaint,onset,location)
                //통신
                apiDisease.postDisease(data).enqueue(object : Callback<DiseasePostResult> {
                    override fun onResponse(call: Call<DiseasePostResult>, response: Response<DiseasePostResult>) {
                        var responseAPI = response.body()
                        if (responseAPI != null) {
                            result1 = responseAPI.result1
                            result2 = responseAPI.result2
                            result3 = responseAPI.result3
                        }
                    }
                    override fun onFailure(call: Call<DiseasePostResult>, t: Throwable) {
                        // 실패
                        Log.d("log",t.message.toString())
                        Log.d("log","fail")
                    }
                })
                Handler().postDelayed({
                    val intent = Intent(this,ChatSelectActivity::class.java)
                    intent.putExtra("id", id )
                    intent.putExtra("cheifcomplaint", cheifcomplaint )
                    intent.putExtra("onset", onset )
                    intent.putExtra("location", location )
                    intent.putExtra("result1", result1 )
                    intent.putExtra("result2", result2 )
                    intent.putExtra("result3", result3 )
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
                    finish()
                }, 5000)
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}