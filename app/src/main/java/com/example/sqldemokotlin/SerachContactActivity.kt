package com.example.sqldemokotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_serach_contact.*

class SerachContactActivity : AppCompatActivity() {
    var dataBaseHelper: DataBaseHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serach_contact)
        dataBaseHelper = DataBaseHelper(this)
        btn_search.setOnClickListener {
            val cursor =
                dataBaseHelper!!.getdata(et_mobile.text.toString())
            while (cursor.moveToNext()) {
                et_name.setText(cursor.getString(1))
                et_email.setText(cursor.getString(3))
            } }
    }
}
