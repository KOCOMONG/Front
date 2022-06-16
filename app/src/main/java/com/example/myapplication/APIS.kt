package com.example.myapplication

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface APIS {
    @POST("/user/signup")
    @Headers("accept: application/json",
        "content-type: application/json")
    fun postUsers(
        @Body jsonbody: PostModel
    ): Call<PostResult>

    companion object {
        private const val BASE_URL = "http://192.168.0.26:8080" // 주소
        fun create(): APIS {
            val gson :Gson =   GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }
}