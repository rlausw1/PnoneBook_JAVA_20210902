package com.nepplus.pnonebook_java_20210902

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nepplus.pnonebook_java_20210902.adapter.PhoneNumAdapter
import com.nepplus.pnonebook_java_20210902.datas.PhoneNumData
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.FileReader
import java.text.SimpleDateFormat

class MainActivity : BaseActivity() {

    val mPhoneNumList = ArrayList<PhoneNumData>()



    lateinit var mAdapter : PhoneNumAdapter


//    0.전화번호 추가 기능 -> 별도 화면에서 저장시키자

//    1. 화면에 들어오면 -> 파일에 저장된 이름,폰번,1988-05-05 문장을 불러내자
//    안드로이드에서 파일 다루는법? + String 분리 / UserData 변환 등등

//    불러낸 데이터들을 -> 리스트뷰에 뿌려주자 (리스트뷰 사용법)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {

        addPhoneNumBtn.setOnClickListener {
//            자바의 인터페이스를 개량한 버젼의 코드
//            EditPhoneNumActivity로 이동 : Intent

            val myIntent = Intent(mContext, EditPhoneNumActivity::class.java)
            startActivity(myIntent)

        }


    }

    override fun setValues() {
        //    임시 방편 : 직접 리스트에 데이터 객체 추가

//    수정 방안 -> 파일을 불러와서 그 내용을 읽고 , PhoneNumData() 로 변환


//        mPhoneNumList.add(PhoneNumData("테스트1", "010-1111-2222"))
//        mPhoneNumList.add(PhoneNumData("테스트2", "010-1111-3333"))
//        mPhoneNumList.add(PhoneNumData("테스트3", "010-1111-4444"))

        mAdapter = PhoneNumAdapter(mContext, R.layout.phone_num_list_item, mPhoneNumList)

//        리스트뷰의 어댑터로 연결
        phoneNumListView.adapter = mAdapter

        readPhoneBookFromFile()
    }


    override fun onResume() {
        super.onResume()
//        파일에서 폰번을 화면에 올때마다 새로 읽어주자
        readPhoneBookFromFile()

    }

    fun readPhoneBookFromFile() {

        val myFile - File(filesDir, "phoneBook.txt")
        val fr = FileReader(myFile)
        val br = BufferedReader(fr)

        val sdf = SimpleDateFormat("yyyy-MM-dd")

//        이 코드는 반복 실해되면 데이터가 누적으로 쌓인다
//        기존에 있던 폰번은 날리고 -> 새로 데이터 담아주자자

        mPhonNumList.clear()

        while(true) {

            val line = br.readLine()
            if (line == null) {


                break
            }
            val infos = line.split(",")
            val phoneNumData = PhoneNumData(infos[0], infos[1])

//            실제 입력한 생년월일로 바꿔주기
//            "1991-05-05"로 분리된 String을 기반으로 => phoneNumData의 일자로 저장
//            SimpleDateFormat의 parse 기능 활용

            phoneNumData.birthDay.time = sdf.parse(infos[2])


            mPhoneNumList.add(phoneNumData)



                }

        br.close()
        fr.close()


//        목록에 내용물이 추가됨 - 리스트뷰도 인지해야함
        mAdapter.notifyDataSetChanged()

       }

    }
