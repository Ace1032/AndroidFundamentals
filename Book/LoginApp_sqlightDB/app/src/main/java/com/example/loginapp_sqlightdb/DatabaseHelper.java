package com.example.loginapp_sqlightdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String ID = "id";
    private static final String F_NAME = "f_name";
    private static final String L_NAME = "l_name";
    private static final String DOB = "dob";
    private static final String ADRESS = "adress";
    private static final String PHONE_N = "phone_n";
    private static final String PASS = "pass";
    private static final String USER_TABLE = "user_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql_statment= "CREATE TABLE " + USER_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + F_NAME + " TEXT, " + L_NAME + " TEXT," +
              " " + DOB + " TEXT, " + ADRESS + " TEXT, " + PHONE_N + " TEXT, " + PASS + " TEXT)";
      db.execSQL(sql_statment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(UserProfile user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        cv.put(F_NAME,user.getFirst_name());
        cv.put(L_NAME,user.getLast_name());
        cv.put(ADRESS,user.getAddress());
        cv.put(PHONE_N,user.getPhone_number());
        cv.put(DOB, user.getDob());
        cv.put(PASS, user.getPassword());
        long insert = db.insert(USER_TABLE, null, cv);
        return (insert>0)? true:false;
    }
}
