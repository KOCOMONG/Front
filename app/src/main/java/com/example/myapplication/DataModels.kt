package com.example.myapplication

//회원 가입
data class PostModel(
    var name : String,
    var id : String,
    var pw : String
)

data class PostResult(
    var result : Int
)
//로그인 ----------
data class LoginPost(
    var id : String,
    var pw : String
)
data class LoginPostResult(
    var login : String,
    var name : String,
    var jud_basicdata : Int
)
//다이어트식단------
data class DietPost(
    var id: String?,
    var want_weight : String?,
    var want_time: String?,
    var practice: String?
)
data class DietPostResult(
    var rice : String,
    var soup : String,
    var sidedish : String,
    var practice_cal : String,
    var food_cal : String
)
//질병식단----
data class DiseaseDietPost(
    var id : String?,
    var practice : String?
)
data class DiseaseDietPostResult(
    var salt : Int,
    var rice : String,
    var soup : String,
    var sidedish : String
)

//챗봇진단1 ----
data class DiseasePost(
    var id : String?,
    var chiefcomplaint : String?,
    var onset : String?,
    var location : String?
)
data class DiseasePostResult(
    var result1 : String,
    var result2 : String,
    var result3 : String
)

//챗봇진단 두번째----
data class DiseaseSecondPost(
    var id : String?,
    var level2_answer : String?,
    var duration : String,
    var course : String,
    var experience : String,
    var character : String,
    var factor : String,
    var associated : String,
    var drug : String,
    var social : String,
    var family : String,
    var traumatic : String
)
data class DiseaseSecondPostResult(
    var name1 : String,
    var name2 : String,
    var name3 : String,
    var percent1 : String,
    var percent2 : String,
    var percent3 : String,
    var synonym1 : String,
    var synonym2 : String,
    var synonym3 : String,
    var department1 : String,
    var department2 : String,
    var department3 : String,
    var explain1 : String,
    var explain2 : String,
    var explain3 : String
)

//기초문진-----
data class BasicDataPost(
    var id : String?,
    var sex : String?,
    var age : String?,
    var height : String?,
    var weight : String?,
    var event : String?,
    var past : String?,
    var feminity : String?
)

data class BasicDataPostResult(
    var result : Int
)

//기초문진 가져오기
data class BasicDataGetResult(
    var sex : Int,
    var age : String,
    var height : String,
    var weight : String,
    var event : String,
    var past : String,
    var feminity : String
)

//의약
data class MedicineGetResult(
    var data : String
)