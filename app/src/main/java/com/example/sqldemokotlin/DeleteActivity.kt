package com.example.sqldemokotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {
    var dataBaseHelper: DataBaseHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        dataBaseHelper = DataBaseHelper(this)
        btn_delete.setOnClickListener {
            dataBaseHelper!!.deleteData(et_mobile.text.toString())
            Toast.makeText(this@DeleteActivity, "Deleted", Toast.LENGTH_SHORT).show()
        }
   }
    }
