package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    //뒤로가기
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }

    private var tmp:Int = 1
    private var max:Int = 3
    private var questionList: List<String> = listOf(
        "어디가 불편한가요?",
        "어떤 증상이 있으신가요?",
        "언제부터 증상이 시작되었나요?",
        "증상이 한번 나타나면 얼마나 지속되나요?",
        "증상의 양상",
        "어떤 경우에 증상이 더 심해지거나 완화되나요?",
        "추가 증상",
        "증상을 완화하기 위해 복용한 약물이 있나요?"
    )
    private var answerList= mutableListOf<String>()

    fun nextQuestion(v:View){
        if(tmp<max) {
            binding.tvQuestion.text = questionList.get(tmp++)
            answerList.add(binding.etAnswer.text.toString())
            binding.etAnswer.setText("")
        }
        else{
            val intent = Intent(this,ChatSelectActivity::class.java)
            intent.putExtra("answer1", answerList.get(0) )
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            finish()
        }
    }
}