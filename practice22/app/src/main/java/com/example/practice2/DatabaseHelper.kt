package com.example.practice2

import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DatabaseContract.DATABASE_NAME, null, 1) {

    // Define SQL query to create the table
    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${UserContract.TABLE_NAME} (" +
                "${UserContract.COLUMN_ID} INTEGER PRIMARY KEY," +
                "${UserContract.EMAIL} TEXT," +
                "${UserContract.COLUMN_PASSWORD} TEXT,"+
                 "${UserContract.first_name} TEXT,"+
                "${UserContract.last_name}TEXT,"+
                "${UserContract.Phone} TEXT)"

    override fun onCreate(db: SQLiteDatabase) {
        // Create the table
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades, if needed
    }

    private val dbHelper: DatabaseHelper = DatabaseHelper(context)
    private val db: SQLiteDatabase = dbHelper.writableDatabase

    fun insertUserName(name: String, pass:String): Long {
        val values = ContentValues().apply {
            put(UserContract.EMAIL, name)
            put(UserContract.COLUMN_PASSWORD,pass)
        }
        return db.insert(UserContract.TABLE_NAME, null, values)
    }

    fun getAllData(): List<String> {
        val dataList = ArrayList<String>()
        val projection = arrayOf(UserContract.TABLE_NAME)
        val selection = null
        val selectionArgs = null
        val sortOrder = null

        val cursor = readableDatabase.query(
            DatabaseContract.DATABASE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )

        while (cursor.moveToNext()) {

        }
        cursor.close()
        return dataList
    }

    fun deleteData(id: Long): Int {
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf(id.toString())
        return db.delete(UserContract.TABLE_NAME, selection, selectionArgs)
    }


}