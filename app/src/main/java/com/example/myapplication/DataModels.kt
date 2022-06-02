package com.example.myapplication

data class HTTP_GET_Model(
    var name : String? =null ,
    var pw : String? =null
)


data class UserModel(
    var id : String? =null
)


data class PostModel(
    var name : String,
    var id : String,
    var pw : String
)

data class PostResult(
    var name : String,
    var id : String,
    var pw : String
)
