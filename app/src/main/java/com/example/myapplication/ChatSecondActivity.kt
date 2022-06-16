package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityChatSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatSecondActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityChatSecondBinding
    private val apiDiseaseSecond = ApiDiseaseSecond.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.getStringExtra("id")
        var cheifcomplaint = intent.getStringExtra("cheifcomplaint")
        var onset = intent.getStringExtra("onset")
        var location = intent.getStringExtra("location")
        var level2_answer = intent.getStringExtra("level2_answer")
        var duration =""
        var course =""
        var experience=""
        var character=""
        var factor=""
        var associated=""
        var drug=""
        var social=""
        var family=""
        var traumatic=""
        var name1 =""
        var name2 =""
        var name3 =""
        var percent1 =""
        var percent2 =""
        var percent3 =""
        var synonym1 =""
        var synonym2 =""
        var synonym3 =""
        var department1 =""
        var department2 =""
        var department3 =""
        var explain1 =""
        var explain2 =""
        var explain3 =""
        var questionList= mutableListOf<String>()
        var tmp:Int = 0
        var max:Int = 0
        if(level2_answer=="급성 복통"){
            max = 6
            questionList.addAll(listOf(
                "증상이 어느 정도 지속되나요? ( 1시간 지속됨 / 간헐적 / 가끔씩 등 )", //Duration
                "증상의 특성 ( 통증의 퍼짐 / 속이 쓰림 / 더부룩함 / 가슴이 답답함 등 ) 을 알려주세요.",//Character
                "동반되는 다른 증상이 있나요? ( 식욕부진 / 구토 / 메스꺼움 / 설사 / 변비 / 적색변 / 흑색변 / 체중감소 / 소변 감소 / 혈뇨 등 )",//Associate :
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 행동으로 인해 변화되었는지 알려주세요. ( 자세에 따른 증상 변화, 식사 전후 증상 변화, 음주 후 증상 변화, 운동 후 증상 변화 등 )",//Factor :
                "현재 투약 중인 약물이 있나요?",//약물 투약력 :
                "평소 생활습관 ( 술, 담배, 커피, 운동 등 ) 에 대해 알려주세요.",//사회력 :
                "기저 질환이 있다면, 알려주세요. ( 고혈압, 당뇨, 고지혈증, 만성 간질환, 결핵 등 )"//과거력 :
            )
            )
        }
        else if(level2_answer=="소화불량/만성 복통") {
            max = 7
            questionList.addAll(listOf(
                "증상이 어느 정도 지속되나요? ( 1시간 지속됨 / 간헐적 / 가끔씩 등 )",
                "증상의 특성 ( 통증의 퍼짐 / 속이 쓰림 / 더부룩함 / 가슴이 답답함 등 ) 을 알려주세요.",
                "동반되는 다른 증상이 있나요? ( 속쓰림 / 설사 / 변비 / 적색변 / 흑색변 / 스트레스 / 신물 올라옴 등 )",
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 행동으로 인해 변화되었는지 알려주세요. ( 자세에 따른 증상 변화, 식사 전후 증상 변화, 음주 후 증상 변화, 운동 후 증상 변화 등 )",
                "현재 투약 중인 약물이 있나요?",
                "평소 생활습관 ( 술, 담배, 커피, 운동 등 ) 에 대해 알려주세요.",
                "비슷한 증상을 가졌던 / 가진 가족이 있나요? ( 대장암 등 )",
                "기저 질환이 있다면, 알려주세요. ( 고혈압, 당뇨, 고지혈증, 만성 간질환, 결핵 등 )"
            ))

        }
        else if(level2_answer=="토혈") {
            max = 6
            questionList.addAll(listOf(
                "증상이 몇 번 발생했나요? ( 1시간 지속됨 / 간헐적 / 가끔씩 등 )",
                "증상의 특성 ( 피의 색 / 기침 도중에 피가 남 / 코나 입에서 피가 남 / 토에 음식물 동반 등 ) 을 알려주세요.",
                "동반되는 다른 증상이 있나요? ( 어지러움 / 숨이 참 / 명치 부위 통증 / 속쓰림 / 혈변 / 가슴 통증 / 피가 나면 잘 멎지 않음 / 코피가 자주 남 / 멍이 잘 듦 / 황달 / 발열 등 )",
                "현재 투약 중인 약물이 있나요?",
                "평소 생활습관 ( 술, 담배, 커피, 운동 등 ) 에 대해 알려주세요.",
                "비슷한 증상을 가졌던 / 가진 가족이 있나요? ( 대장암 등 )",
                "기저 질환이 있다면, 알려주세요. ( 고혈압, 당뇨, 고지혈증, 만성 간질환, 결핵 등 )"
            ))
        }
        else if(level2_answer=="피부발진") {
            max = 3
            questionList.addAll(listOf(
                "증상의 특성 ( 발진 위가 커지커나 퍼짐 / 증상이 나타났다가 사라짐 / 발진 위에 가려움이나 통증 동반 등 ) 을 알려주세요.",
                "동반되는 다른 증상이 있나요? ( 발열 / 오한 / 관절통증  / 피로 / 구강궤양 / 성기 양 등 )",
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 행동으로 인해 변화되었는지 알려주세요. ( 새 옷 장신구 착용 / 새로운 화장품 이용 / 음주 / 처음 먹어본 음식 /  알레르기 등 )",
                "비슷한 증상을 가졌던 / 가진 가족이 있나요?"
            ))

        }
        else if(level2_answer=="다뇨증") {
            max = 3
            questionList.addAll(listOf(
                "증상의 특징 ( 1회 소변량 (종이컵 기준) / 소변의 색 / 소변의 농도 등 ) 을 알려주세요.",
                "동반되는 다른 증상이 있나요? ( 반복되는 갈증 / 소변을 보기 위해 잠에서 깸 / 체중 감소 / 두통 / 메스꺼움 / 시야장애 / 전신의 쇠약 / 무력감 / 피부 가려움 / 발열 / 소변 볼 때 아랫배 통증 등 )",
                "현재 복용 중인 약물이 있나요?  한약, 건강보조식품, 다이어트 식품도 모두 적어주세요.",
                "가족 중에 당뇨를 진단 받으신 분이 있나요?"
            ))
        }
        else if(level2_answer=="핍뇨") {
            max = 3
            questionList.addAll(listOf(
                "소변을 하루에 몇 회 정도 보나요? 몇 시간 간격으로 소변을 보놔요?",
                "증상에 대해 ( 1회 소변량 (종이컵 기준) / 소변의 색 / 소변의 농도 등 ) 알려주세요.",
                "동반되는 다른 증상이 있나요? ( 반복되는 갈증 / 소변을 보기 위해 잠에서 깸 / 체중 감소 / 두통 / 메스꺼움 / 시야장애 / 전신의 쇠약 / 무력감 / 피부 가려움 / 발열 / 소변 볼 때 아랫배 통증 등 )",
                "현재 복용 중인 약물이 있나요?  한약, 건강보조식품, 다이어트 식품도 모두 적어주세요."
            ))
        }
        else if(level2_answer=="붉은색 소변") {
            max = 5
            questionList.addAll(listOf(
                "증상에 대해 ( 1회 소변량 (종이컵 기준) / 소변의 색 / 소변의 농도 / 혈뇨가 소변 보는 내내 나옴 등 ) 알려주세요.",
                "동반되는 다른 증상이 있나요? ( 소변 볼 때 아랫배 통증 / 잔뇨감 / 피로 / 발열 / 오한 / 얼굴이나 다리 등 몸이 부음 / 멍이 잘 듦 / 잇몸 피 / 옆구리 통증 등 )",
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 행동으로 인해 변화되었는지 알려주세요. ( 성관계 / 심한 운동 / 감기 / 사우나 / 다이어트 등 )",
                "새로 복용한 약물이 있나요?",
                "가족 중에 혈뇨가 있거나 콩팥 질환을 가지고 있는 분이 있나요?",
                "투병 중이거나 진단받았던 질병을 알려주세요. ( 혈관염 / 루푸스신염 / 출혈성 질환 / 항암치료 / 고혈압 / 결핵 등)"
            ))
        }
        else if(level2_answer=="배뇨 이상") {
            max = 5
            questionList.addAll(listOf(
                "하루에 소변을 몇 회 보나요? 해당되는 증상이 있으면 작성해주세요. ( 잔뇨감 / 혈뇨 / 거품뇨 / 탁한 소변 / 배뇨통 / 요실금 / 빈뇨 / 야뇨 / 절박뇨 / 요 정체 등 )",
                "동반되는 다른 증상이 있나요? ( 발열 / 오한 / 옆구리 통증 / 체중 감소 / 시야장애 / 근육통 등 )",
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 경우였는지 알려주세요. ( 날씨, 자세, 기침 및 웃음 등 )",
                "현재 복용 중인 약물이 있나요?",
                "최근 성관계를 가진 적이 있다면 적어주세요.",
                "투병 중이거나 진단받았던 질병을 알려주세요. ( 척추 손상, 뇌졸중, 치매, 파킨슨 병 등의 신경계 질환 / 전립선 또는 요로 계통 질환 / 당뇨 등)"
            ))
        }
        else if(level2_answer=="소변찔끔증") {
            max = 6
            questionList.addAll(listOf(
                "통증의 진행 상황이 어떻게 되나요? ( 심해짐 / 가끔씩 아플 때가 있음 등 )",
                "한번 증상이 나타날 때 소변이 얼마나 새는지 알려주세요. ( 속옷을 약간 적시는 정도 등 ) 하루에 몇 번 정도 증상이 나타나요? ( 하루 10번 등 ) 해당되는 증상을 모두 작성해주세요. ( 배뇨통 / 혈뇨 / 잔뇨감 / 거품뇨 / 빈뇨 / 야뇨 / 절박뇨 / 요 정체 등 )",
                "동반되는 다른 증상이 있나요? ( 허리 통증 / 체중변화 등 )",
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 경우였는지 알려주세요. ( 운동, 자세, 무거운 것을 들 때, 기침, 큰소리로 웃을 때 등 )",
                "현재 복용 중인 약물이 있나요?",
                "술이나 커피 (카페인 음료)는 얼마나 많이 드시나요?",
                "투병 중이거나 진단받았던 질병을 알려주세요. ( 고혈압, 당뇨, 척추 디스크, 척수 손상, 뇌졸중 등)"
            ))
        }
        else if(level2_answer=="관절 통증") {
            max = 6
            questionList.addAll(listOf(
                "통증이 한 번 시작되면 얼마나 오랫동안 지속되나요?",
                "통증의 정도를 알려주세요. ( 욱신거리는 느낌 / 관절 깊은 부위의 통증 / 관절 주변부 통증 등 )",
                "동반되는 다른 증상이 있나요? ( 관절 주의의 붓기 / 발열 / 관절이 비대칭적으로 아픔 / 입이나 눈이 마름 / 성기가 헐음 / 추운 곳에 가면 손, 발가락이 하얗게 또는 새파랗게 변함 / 열감 등 )",
                "어떻게 통증이 시작되었나요? (무리한 운동 / 관절 주변 상처 등) 어떤 경우에 통증이 완화되거나 더 심해지나요? ( 오전에 심함, 햇빛 받으면 피부발진 생기고 관절통 심해짐 등)",
                "현재 복용 중인 약물이 있나요?",
                "가족 중에 관절염을 진단받거나 치료받은 분이 있다면 적어주세요.",
                "다음과 같은 질환을 진단받거나 치료받은 적이 있다면 적어주세요. ( 고혈압, 통풍, 류마티스 질환 등 ) 최근 심한 설사를 했거나 목 감기를 앓은 적이 있다면 입력해주세요."
            ))
        }
        else{
            max = 9
            questionList.addAll(listOf(
                "증상이 어느 정도 지속되나요? ( 1시간 지속됨 / 간헐적 / 가끔씩 등 )",
                "통증의 진행 상황이 어떻게 되나요? ( 심해짐 / 가끔씩 아플 때가 있음 등 )",
                "이전에도 비슷한 증상이 나타난 적이 있나요?",
                "증상의 특성 ( 색, 양, 세기, 냄새 등 ) 을 알려주세요.",
                "동반되는 다른 증상이 있나요?",
                "증상이 악화되었거나 완화된 적이 있나요? 만약 그렇다면, 어떤 행동으로 인해 변화되었는지 알려주세요. ( 자세에 따른 증상 변화, 식사 전후 증상 변화, 음주 후 증상 변화, 운동 후 증상 변화 등 )",
                "현재 투약 중인 약물이 있나요?",
                "평소 생활습관 ( 술, 담배, 커피, 운동 등 ) 에 대해 알려주세요.",
                "비슷한 증상을 가졌던 / 가진 가족이 있나요?",
                "기저 질환이 있다면, 알려주세요. ( 고혈압, 당뇨, 고지혈증, 만성 간질환, 결핵 등 )"
            ))
        }
        binding.tvQuestion.text = questionList[0]
        var answerList= mutableListOf<String>()
        binding.imageButton.setOnClickListener{
            if(tmp<max) {
                binding.tvQuestion.text = questionList[++tmp]
                answerList.add(binding.etAnswer.text.toString())
                binding.etAnswer.setText("")
            }
            else{
                answerList.add(binding.etAnswer.text.toString())
                if(level2_answer=="급성 복통"){
                    duration=answerList[0]
                    character=answerList[1]
                    associated=answerList[2]
                    factor=answerList[3]
                    drug=answerList[4]
                    social=answerList[5]
                    traumatic=answerList[6]
                }
                else if(level2_answer=="소화불량/만성 복통") {
                    duration=answerList[0]
                    character=answerList[1]
                    associated=answerList[2]
                    factor=answerList[3]
                    drug=answerList[4]
                    social=answerList[5]
                    family=answerList[6]
                    traumatic=answerList[7]
                }
                else if(level2_answer=="토혈") {
                    duration=answerList[0]
                    character=answerList[1]
                    associated=answerList[2]
                    drug=answerList[3]
                    social=answerList[4]
                    family=answerList[5]
                    traumatic=answerList[6]
                }
                else if(level2_answer=="피부발진") {
                    character=answerList[0]
                    associated=answerList[1]
                    factor=answerList[2]
                    family=answerList[3]
                }
                else if(level2_answer=="다뇨증") {
                    character=answerList[0]
                    associated=answerList[1]
                    drug=answerList[2]
                    family=answerList[3]
                }
                else if(level2_answer=="핍뇨") {
                    duration=answerList[0]
                    character=answerList[1]
                    associated=answerList[2]
                    drug=answerList[3]
                }
                else if(level2_answer=="붉은색 소변") {
                    character=answerList[0]
                    associated=answerList[1]
                    factor=answerList[2]
                    drug=answerList[3]
                    family=answerList[4]
                    traumatic=answerList[5]
                }
                else if(level2_answer=="배뇨 이상") {
                    character=answerList[0]
                    associated=answerList[1]
                    factor=answerList[2]
                    drug=answerList[3]
                    social=answerList[4]
                    traumatic=answerList[5]
                }
                else if(level2_answer=="소변찔끔증") {
                    course=answerList[0]
                    character=answerList[1]
                    associated=answerList[2]
                    factor=answerList[3]
                    drug=answerList[4]
                    social=answerList[5]
                    traumatic=answerList[6]
                }
                else if(level2_answer=="관절 통증") {
                    duration=answerList[0]
                    character=answerList[1]
                    associated=answerList[2]
                    factor=answerList[3]
                    drug=answerList[4]
                    family=answerList[5]
                    traumatic=answerList[6]
                }
                else{
                    duration=answerList[0]
                    course=answerList[1]
                    experience=answerList[2]
                    character=answerList[3]
                    associated=answerList[4]
                    factor=answerList[5]
                    drug=answerList[6]
                    social=answerList[7]
                    family=answerList[8]
                    traumatic=answerList[9]
                }

                var data = DiseaseSecondPost(id,level2_answer,duration,course,experience,character,factor,associated,drug,social,family,traumatic)
                apiDiseaseSecond.postDiseaseSecond(data).enqueue(object :
                    Callback<DiseaseSecondPostResult> {
                    override fun onResponse(call: Call<DiseaseSecondPostResult>, response: Response<DiseaseSecondPostResult>) {
                        var responseAPI = response.body()
                        if (responseAPI != null) {
                            name1 = responseAPI.name1
                            name2 = responseAPI.name2
                            name3 = responseAPI.name3
                            percent1 = responseAPI.percent1
                            percent2 = responseAPI.percent2
                            percent3 = responseAPI.percent3
                            synonym1 = responseAPI.synonym1
                            synonym2 = responseAPI.synonym2
                            synonym3 = responseAPI.synonym3
                            department1 = responseAPI.department1
                            department2 = responseAPI.department2
                            department3 = responseAPI.department3
                            explain1 = responseAPI.explain1
                            explain2 = responseAPI.explain2
                            explain3 = responseAPI.explain3
                        }
                    }
                    override fun onFailure(call: Call<DiseaseSecondPostResult>, t: Throwable) {
                        // 실패
                        Log.d("log",t.message.toString())
                        Log.d("log","fail")
                    }
                })

                Handler().postDelayed({
                    val intent = Intent(this,ChatResultActivity::class.java)
                    intent.putExtra("name1", name1 )
                    intent.putExtra("name2", name2 )
                    intent.putExtra("name3", name3 )
                    intent.putExtra("percent1", percent1 )
                    intent.putExtra("percent2", percent2 )
                    intent.putExtra("percent3", percent3 )
                    intent.putExtra("synonym1", synonym1 )
                    intent.putExtra("synonym2", synonym2 )
                    intent.putExtra("synonym3", synonym3 )
                    intent.putExtra("department1", department1 )
                    intent.putExtra("department2", department2 )
                    intent.putExtra("department3", department3 )
                    intent.putExtra("explain1", explain1 )
                    intent.putExtra("explain2", explain2 )
                    intent.putExtra("explain3", explain3 )

                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
                    finish()
                }, 5000)

            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_down_exit)
    }
}