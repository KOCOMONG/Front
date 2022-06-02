package com.example.myapplication

import retrofit2.http.Body

//아웃풋
data class Login(
    //json key 값이랑 동일
    var result : String
)
data class LoginData(
    var name : String,
    var id : String,
    var pw : String
)