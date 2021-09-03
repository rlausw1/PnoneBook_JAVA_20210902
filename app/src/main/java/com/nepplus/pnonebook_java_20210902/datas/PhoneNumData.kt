package com.nepplus.pnonebook_java_20210902.datas

import java.text.SimpleDateFormat
import java.util.*

class PhoneNumData(var name: String, var phoneNum: String, birthDay: Calendar) {

//    init {
////        생성자가 실행될떄 추가 동작시킬 코드 작성
//        this.name = name
//    }


    val birthDay = Calendar.getInstance() //기본값 : 오늘 날짜
    //set 기능으로 내부에 적힌 값을 바꿈 -> 새 객체를 집어 넣는 방식이 아님
    //변수의 입장에서는 연결된 객체가 바뀔일이 없다 -> val로 만들어주자


//    가진데이터를 => 파일 저장할수 있는 양식 "이름/폰번/생년월일"

    val fileDateFormat = SimpleDateFormat("yyyy-MM-dd")


    fun getFileFormatData(): String {

//        코틀린에서 String 가공
//    벌스데이(Calendar) 가공
        return "${this.name},${this.phoneNum},${fileDateFormat.format(this.birthDay.time)}"

    }

//    생년월일을 -> 5월5일 등의 생일양식으로 가공 함수
    val birthDayFormatter = SimpleDateFormat("M월 d일")
    fun getFormattedBirthday() : String {
        return birthDayFormatter.format(this.birthDay.time)

    }


}