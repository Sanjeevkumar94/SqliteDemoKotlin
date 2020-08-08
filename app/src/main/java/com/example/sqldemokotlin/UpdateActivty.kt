package com.example.sqldemokotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_update_activty.*

class UpdateActivty : AppCompatActivity() {
    var dataBaseHelper: DataBaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_activty)
        dataBaseHelper = DataBaseHelper(this)
        btn_update.setOnClickListener {
            dataBaseHelper!!.updateData(
                et_email.getText().toString(),
                et_name.getText().toString(),
                et_mobile.getText().toString()
            )
            Toast.makeText(this@UpdateActivty, "Update SuucessFully", Toast.LENGTH_SHORT).show() }

    }
}
