package com.example.testsqllight;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "customer_table";
    public static final String CUSTOMER_NAME = "customer_name";
    public static final String CUSTOMER_AGE = "customer_age";
    public static final String VAL_CUSTOMER = "val_customer";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqdb) {
        String sqlStatement= "CREATE TABLE " + CUSTOMER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " " + CUSTOMER_NAME + " TEXT, " + CUSTOMER_AGE + " INTEGER, " +
                VAL_CUSTOMER + " BOOL)";
        sqdb.execSQL(sqlStatement);
    }
    public boolean addOne(Customer customer){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(CUSTOMER_NAME,customer.name);
        cv.put(CUSTOMER_AGE,customer.age);
        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if(insert>0){return true;
        }
        else{
            return false;
        }


    }

    public ArrayList<Customer> getList(){
        ArrayList<Customer> customerArrayList= new ArrayList<>();
        String sql_qury="SELECT * FROM "+CUSTOMER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql_qury, null);
        if(cursor.moveToNext()){
            do{
                int customer_id=cursor.getInt(0);
                String customer_name=cursor.getString(1);
                int customer_age=cursor.getInt(2);
                Customer customer=new Customer(customer_name,customer_age,customer_id);
                customerArrayList.add(customer);
            }while(cursor.moveToNext());
        }else{

        }

        return customerArrayList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
