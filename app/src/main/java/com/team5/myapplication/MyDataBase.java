package com.team5.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final  String DB_NAME = "danhgia.sqlite";
    private static final String TBL_NAME="Baidanhgia";
    private static final String COL_B_ID="B_ID";
    private static final String COL_B_DES="B_Des";
    private static final String COL_B_PHOTO="B_Photo";

    public MyDataBase(@Nullable Context context){
                      super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + COL_B_DES + " VARCHAR(200)," + COL_B_PHOTO + " BLOB)"  ;
                sqLiteDatabase.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }
    public void queryExec( String sql){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getWritableDatabase();
        return db.rawQuery(sql, null);
    }
    public boolean insertData(String des, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TBL_NAME + " VALUES(null, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, des);
            statement.bindBlob(2, photo);
            statement.executeInsert();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
