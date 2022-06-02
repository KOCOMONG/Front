package com.example.myapplication

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


//인풋
interface LoginService{
    //@FormUrlEncoded
    @POST("userlist")
    fun requestLogin(
        @Body body: LoginData
    ) : Call<ResponseBody>
}

