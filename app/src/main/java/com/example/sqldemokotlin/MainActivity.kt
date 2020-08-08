package com.example.sqldemokotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_insert.setOnClickListener {
            val intent = Intent(this@MainActivity, InsertActivity::class.java)
            startActivity(intent)
        }

        btn_search.setOnClickListener {
            val intent = Intent(this@MainActivity, SerachContactActivity::class.java)
            startActivity(intent)
        }
        btn_delete.setOnClickListener {
            val intent = Intent(this@MainActivity, DeleteActivity::class.java)
            startActivity(intent)
        }
        btn_update.setOnClickListener {
            val intent = Intent(this@MainActivity, UpdateActivty::class.java)
            startActivity(intent) }
    }
}
