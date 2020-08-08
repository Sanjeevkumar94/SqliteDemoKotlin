package com.example.sqldemokotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {
    var dataBaseHelper: DataBaseHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        dataBaseHelper = DataBaseHelper(this)
        btn_save.setOnClickListener {
            val result = dataBaseHelper!!.insertData(
                et_name.text.toString(),
                et_mobile.text.toString().toInt(),
                et_email.text.toString()
            )

            if (result) {
                Toast.makeText(this@InsertActivity, "Data Saved", Toast.LENGTH_SHORT).show()
            } }

    }
}
