package com.example.happy.newsreader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by happy on 11/28/2016.
 */

public class dataBaseHandler  extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="news_dbManager";
    private static final String TABLE_NEWS="news";
    private static final String key_id="id";
    private static final String News_Title="title";
    private static final String _url="url";
    private static final String  _desc="des";
    private static final String _im_id="id";
    private static final String  _author="author";

    public dataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NEWS_TABLE="CREATE TABLE" +TABLE_NEWS +"("
                +key_id+"INTEGER PRIMARY KEY" +News_Title+"TEXT,"+ _url+"TEXT,"
                +_desc+"TEXT,"+ _im_id+"TEXT,"+_author+"TEXT"+")";
        db.execSQL(CREATE_NEWS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NEWS);
        onCreate(db);
    }

    void addnews(news_db N_db){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(News_Title,N_db.get_News_Title());
        values.put(_url,N_db.get_url());
        values.put(_author,N_db.get_author());
        values.put(_desc,N_db.get_desc());
        values.put(_im_id,N_db.get_im_id());

        db.insert(TABLE_NEWS, null,values);
        db.close();

    }
/**
    news_db getNews(){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.query()
        return
    }
 **/
}
