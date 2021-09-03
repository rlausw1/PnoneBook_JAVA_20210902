package com.nepplus.pnonebook_java_20210902.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nepplus.pnonebook_java_20210902.R
import com.nepplus.pnonebook_java_20210902.datas.PhoneNumData

class PhoneNumAdapter(val mContext : Context,
                      resId : Int,
                      val mList : List<PhoneNumData>) : ArrayAdapter<PhoneNumData> (mContext, resId, mList) {

                          private val mInflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        getView : xml(우리가 만든 xml로 커스텀) -> position에 맞는 데이터를 입혀서 - 리스트 뷰의 각 position에 뿌려주자
        var row = convertView
        if ( row == null ) {
            row = mInflater.inflate(R.layout.phone_num_list_item, null)
        }

        row!!

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val birthDatTxt = row.findViewById<TextView>(R.id.birthDayTxt)
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNumTxt)

        val data = mList.get(position)
        nameTxt.text = data.name
        phoneNumTxt.text = data.phoneNum

//        nameTxt.setText(data.getName() )

        birthDatTxt.text = data.getFormattedBirthday()

        return row



    }



}
