package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var textId = binding.etId.text.toString()
//        var textPw = binding.etPassword.text.toString()

        var textId = "myID"
        var textPw = "PW"

        var myRetrofit = Retrofit.Builder()
            .baseUrl("http://172.30.1.24:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginService: LoginService = myRetrofit.create(LoginService::class.java)

        var loginData = LoginData(textId,textId,textPw)

        binding.btnLogin.setOnClickListener{


        val intent = Intent(this,BasicQuestionActivity::class.java)
        startActivity(intent)
        finish()

//            loginService.requestLogin(loginData).enqueue(object : Callback<ResponseBody> {
//                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//
//
//                        통신 성공 시 응답 값 받아옴
//                        var login = response.body()
//                        Log.d("LOGIN", "result : " + login?.result)
//
//                        var dialog = AlertDialog.Builder(this@LoginActivity)
//                        dialog.setTitle(login?.result)
//                        dialog.setMessage(login?.result)
//                        dialog.show()
//
//                    var dialog = AlertDialog.Builder(this@LoginActivity)
//                    dialog.setTitle("성공")
//                    dialog.setMessage(response.body()!!.toString())
//                    dialog.show()
//
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    //통신 실패 시
//                    var dialog = AlertDialog.Builder(this@LoginActivity)
//                    dialog.setTitle("에러")
//                    dialog.setMessage("호출실패.")
//                    dialog.show()
//                }



           // })
        }



    }

//    override fun onClick(view: View?) {
//        when ( view!!.id) {
//            R.id.btn_login -> {
//                login(view)
//            }
//        }
//    }

    private fun login(v: View) {
        /*
//        var textId = binding.etId.text.toString()
//        var textPw = binding.etPassword.text.toString()
//
//        var retrofit = Retrofit.Builder()
//            .baseUrl("http://172.30.1.13:8080")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        var loginService: LoginService = retrofit.create(LoginService::class.java)
//
//        var loginData = LoginData(textId,textId,textPw)

        loginService.requestLogin(loginData).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {


//                //통신 성공 시 응답 값 받아옴
//                var login = response.body()
//                Log.d("LOGIN", "msg : " + login?.msg)
//                Log.d("LOGIN", "code : " + login?.code)
//
//                var dialog = AlertDialog.Builder(this@LoginActivity)
//                dialog.setTitle(login?.msg)
//                dialog.setMessage(login?.code)
//                dialog.show()


                var dialog = AlertDialog.Builder(this@LoginActivity)
                dialog.setTitle("성공")
                dialog.setMessage(response.body()!!.toString())
                dialog.show()

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //통신 실패 시
                var dialog = AlertDialog.Builder(this@LoginActivity)
                dialog.setTitle("에러")
                dialog.setMessage("호출실패.")
                dialog.show()
            }

        })
*/

//        val intent = Intent(this,BasicQuestionActivity::class.java)
//        startActivity(intent)
//        finish()

    }


    fun signUp(v: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        finish()
    }
}
