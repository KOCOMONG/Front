package com.example.myapplication

import android.content.ContentValues.TAG
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

    @GET("/user")
    @Headers("accept: application/json",
        "content-type: application/json")
    fun getUsers(
    ): Call<HTTP_GET_Model>


    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "http://172.30.1.24:8080" // 주소
        fun create(): APIS {

//            val clientBuilder = OkHttpClient.Builder()
//            val loggingInterceptor = HttpLoggingInterceptor()
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//            clientBuilder.addInterceptor(loggingInterceptor)
//
//            Log.d(TAG, "initMyAPI : $BASE_URL")

            val gson :Gson =   GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }
}