package com.team5.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelper_TaiKhoan extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;
    public static final String DB_NAME="users.sqlite";
    public static final String TBL_NAME="UserDetails";
    public static final String COL_W_TEN="W_TEN";
    public static final String COL_W_EMAIL="W_EMAIL";
    public static final String COL_W_GIOITINH="W_GIOITINH";
    public static final String COL_W_SODIENTHOAI="W_SODIENTHOAI";
    public static final String COL_W_NGAYSINH="W_NGAYSINH";




    public DatabaseHelper_TaiKhoan(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_W_TEN + " VARCHAR(200), " + COL_W_EMAIL + " VARCHAR(100), " + COL_W_GIOITINH + " VARCHAR(100), " + COL_W_SODIENTHOAI + " VARCHAR(100)," + COL_W_NGAYSINH+ " VARCHAR(100))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public boolean insertData( String TEN,String EMAIL,String GIOITINH, String SODIENTHOAI, String NGAYSINH) {
        SQLiteDatabase db = getWritableDatabase();
        try{
            String sql = "INSERT INTO " + TBL_NAME + " VALUES( ?, ?, ?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, TEN);
            statement.bindString(2, EMAIL);
            statement.bindString(3, GIOITINH);
            statement.bindString(4, SODIENTHOAI);
            statement.bindString(5, NGAYSINH);

            statement.executeInsert();
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
