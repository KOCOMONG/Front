package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityLoginBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val apiLogin = ApiLogin.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = ""
        var pw = ""
        var login = "" // succeed/fail
        var name = "" // 이름값
        var jud_basicdata = "0" //있으면 1, 없으면 0

        binding.btnLogin.setOnClickListener {
            id = binding.etId.text.toString()
            pw = binding.etPassword.text.toString()
            var data = LoginPost(id,pw)
            //통신
            apiLogin.postLogin(data).enqueue(object : Callback<LoginPostResult> {
                override fun onResponse(call: Call<LoginPostResult>, response: Response<LoginPostResult>) {
                    var responseAPI = response.body()
                    if (responseAPI != null) {
                        login = responseAPI.login
                        name = responseAPI.name
                        jud_basicdata = responseAPI.jud_basicdata.toString()
                    }
                }
                override fun onFailure(call: Call<LoginPostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })

            Handler().postDelayed({
                if(login=="succeed") {
                    if (jud_basicdata == "0") {
                        val intent = Intent(this, BasicQuestionActivity::class.java)
                        intent.putExtra("id", id)
                        intent.putExtra("name", name)
                        intent.putExtra("key", "home")
                        startActivity(intent)
                        finish()
                    } else if (jud_basicdata == "1") {
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("id", id)
                        intent.putExtra("name", name)
                        startActivity(intent)
                        finish()
                    }
                }
                else if(login=="fail"){
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("알림")
                    dialog.setMessage("로그인에 실패하였습니다.\n아이디 혹은 비밀번호를 확인하세요.")
                    dialog.show()
                }
            }, 1200)
        }
    }

    fun signUp(v: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        finish()
    }
}
