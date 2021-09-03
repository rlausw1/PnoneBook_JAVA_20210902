package com.nepplus.pnonebook_java_20210902

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import java.text.SimpleDateFormat
import java.util.*

class EditPhoneNumActivity : BaseActivity() {

//    선택된 날짜의 기본값 : 화면을 연 일시
    val mSelectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)
        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {

        okBtn.setOnClickListener {
//          1. 입력한 값들을 변수에 저장
            val inputName = nameEdt.text.toString()
            val inputPhoneNum = phoneNumEdt.text.toString()

//            생년월이 (calendar) -> 1988-05-05 String => simpeDataFormat
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val birthDayStr = sdf.format(mSelectedDate.time)

//            2. 폰번 데이터 객체로 만들자 ( 클래스 추가)


//            3. 이름/폰번/생년 양식으로 가공 -> 파일에 저장

        }

        selectBirthDayBtn.setOnClickListener{
//          달력처럼, 날짜 선택 팝업 출현

            val dateSetListener = object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

//            날짜가 선택되면 실행해줄 코드(년/월/일 세개의 Int 가지고 처리)

                    mSelectedDate.set(year, month, dayOfMonth)
//            날짜 선택이 완료되면 (Calendar)되면 -> birthDayTxt에 반영 ( String 반영)
//            Calendar -> String 가공 : SimpleDataFormat
//                    1988.10.28 양식으로 가공

                    val sdf = SimpleDateFormat("yyyy. MM. dd ")
                    birthDayTxt.text = sdf.format( mSelectedDate.time)

                }

            }
//달력 띄울때 넣는 날짜? 기본 선택값을 넣자
//            기본 선택값 : 오늘 날짜 => Calendar를 하나 만들면 기본값이 오늘날짜
//            calendar 만든다 : 멤버변수로 만들어서 -> 선택된 값을 저장하는 용도로도

            val datePickerDialog = DatePickerDialog(mContext, dateSetListener,
                mSelectedDate.get(Calendar.YEAR),
                mSelectedDate.get(Calendar.MONTH),
                mSelectedDate.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.show()


        }


    }

    override fun setValues() {


    }
}