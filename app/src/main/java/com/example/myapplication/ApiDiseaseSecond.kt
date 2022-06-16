package com.example.myapplication

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface ApiDiseaseSecond {
    @POST("/model/disease")
    @Headers("accept: application/json",
        "content-type: application/json")
    fun postDiseaseSecond(
        @Body jsonbody: DiseaseSecondPost
    ): Call<DiseaseSecondPostResult>




    companion object {
        private const val BASE_URL = "http://192.168.0.26:8080" // 주소

        fun create(): ApiDiseaseSecond {
            val gson :Gson =   GsonBuilder().setLenient().create()

            var okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiDiseaseSecond::class.java)
        }
    }
}