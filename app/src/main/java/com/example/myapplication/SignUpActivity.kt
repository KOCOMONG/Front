package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import androidx.appcompat.app.AlertDialog
import okhttp3.ResponseBody

class SignUpActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySignupBinding
    private val api = APIS.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
            finish()
        }




//        binding.btnSignup.setOnClickListener {
//            api.getUsers().enqueue(object : Callback<HTTP_GET_Model> {
//                override fun onResponse(call: Call<HTTP_GET_Model>, response: Response<HTTP_GET_Model>) {
//                    Log.d("log",response.toString())
//                    Log.d("log", response.body().toString())
//                    if(!response.body().toString().isEmpty())
//                        binding.etId.setText(response.body().toString());
//                }
//
//                override fun onFailure(call: Call<HTTP_GET_Model>, t: Throwable) {
//                    // 실패
//                    Log.d("log",t.message.toString())
//                    Log.d("log","fail")
//                }
//            })
//        }

        binding.btnSignup.setOnClickListener {
            val data = PostModel("name","ID","PW")

            api.postUsers(data).enqueue(object : Callback<PostResult> {
                override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                    Log.d("log",response.toString())
                    Log.d("log", response.body().toString())
                    if(response.body().toString().isNotEmpty())
                        binding.etSignupId.setText(response.body().toString())
                }

                override fun onFailure(call: Call<PostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })
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
        finish()
    }

}