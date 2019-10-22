package com.example.zaeem.sms_body_broad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "Mydatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Student (id INTEGER PRIMARY KEY AUTOINCREMENT,Message TEXT,Phone TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }





    public boolean Insert(String table,ContentValues contentValues)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        long result =  db.insert(table,null,contentValues);



        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }



    }









    public Cursor getData(String table)
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT *FROM "+table,null);
        return cursor;
    }






}
