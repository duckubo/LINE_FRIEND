package com.team5.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username Text primary key,password Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL(" drop Table if exists users");
    }
    public boolean insertData(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contenValues = new ContentValues();
        contenValues.put("username", username);
        contenValues.put("password", password);
        long result = myDB.insert("users",null,contenValues);
        if(result== -1 ){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean updatepassword(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contenValues = new ContentValues();
        contenValues.put("password", password);
        long result = myDB.update("users", contenValues, "username = ? ", new String[] {username});
        if(result== -1 ){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase myDB =this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery(" select * from users where username = ? ", new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkusernamePassword(String username, String password)
    {
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username = ? and password= ?", new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean updatenewpassword( String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contenValues = new ContentValues();
        contenValues.put("password", password);
        long result = myDB.update("users", contenValues, "password = ? ", new String[] {password});
        if(result== -1 ){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkuserpassword(String password)
    {
        SQLiteDatabase myDB =this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery(" select * from users where password = ? ", new String[]{password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
