package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.myapplication.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import androidx.appcompat.app.AlertDialog

class SignUpActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySignupBinding
    private val api = APIS.create()
    var result =""//성공 1, 실패 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var name =""
        var id =""
        var pw =""
        binding.btnSignup.setOnClickListener {
            name = binding.etSignupName.text.toString()
            id = binding.etSignupId.text.toString()
            pw = binding.etSignupPassword.text.toString()
            val dataS = PostModel(name,id,pw)
            //통신
            api.postUsers(dataS).enqueue(object : Callback<PostResult> {
                override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                    var responseAPI = response.body()
                    if (responseAPI != null) {
                        result = responseAPI.result.toString()
                        Log.d("log_1",result)
                    }
                }
                override fun onFailure(call: Call<PostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })
            Log.d("log_2",result)
            Handler().postDelayed({
                if (result=="1"){
                    var dialog = AlertDialog.Builder(this@SignUpActivity)
                    dialog.setTitle("알림")
                    dialog.setMessage("회원가입에 성공하셨습니다.\n로그인 창으로 돌아가 로그인을 진행해주세요.")
                    dialog.show()
                }
                else if (result=="0"){
                    var dialog = AlertDialog.Builder(this@SignUpActivity)
                    dialog.setTitle("알림")
                    dialog.setMessage("이미 존재하는 아이디입니다.\n다른 아이디를 사용해주세요.")
                    dialog.show()
                }
            }, 2000)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
        finish()
    }
    fun signUp(v:View){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
        finish()
    }
}