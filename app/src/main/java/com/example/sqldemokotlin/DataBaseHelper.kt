package com.example.sqldemokotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)")
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("drop table $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(
        name: String?,
        mobile_number: Int,
        email: String?
    ): Boolean {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("NAME", name)
        contentValues.put("MOBILE_NUMBER", mobile_number)
        contentValues.put("EMAIL", email)
        val result =
            sqLiteDatabase.insert(TABLE_NAME, null, contentValues)
        return if (result == -1L) false else true
    }

    fun getdata(mobileNumber: String): Cursor {
        val sqLiteDatabase = this.writableDatabase
        val query =
            "SELECT * FROM $TABLE_NAME WHERE MOBILE_NUMBER = '$mobileNumber'"
        return sqLiteDatabase.rawQuery(query, null)
    }

    fun deleteData(mobile_number: String) {
        val sqLiteDatabase = this.writableDatabase
        sqLiteDatabase.delete(
            TABLE_NAME,
            " MOBILE_NUMBER = '$mobile_number'",
            null
        )
        sqLiteDatabase.close()
    }

    fun updateData(number: String, name: String?, emai: String?) {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("NAME", name)
        contentValues.put("EMAIL", emai)
        sqLiteDatabase.update(
            TABLE_NAME,
            contentValues,
            "MOBILE_NUMBER = '$number'",
            null
        )
        sqLiteDatabase.close()
    }

    companion object {
        private const val DATABASE_NAME = "contacts.db"
        private const val TABLE_NAME = "contact"
    }

    init { // it will create database when you will create object.
        val db = this.writableDatabase
    }
}