package com.seuic.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "main.db";
    private final static int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        
        // 创建userInfo表
        String sqlStr = "CREATE TABLE userInfo (userid text NOT NULL,username text NOT NULL,userpwd text NOT NULL,unitname text,rolename text,unittype text,unit text,curdate text)";
        sqLiteDatabase.execSQL(sqlStr);

        // 创建 bill 表
        sqlStr = "CREATE TABLE bill (flowid TEXT,srvtype INTEGER,cpid TEXT,batchno TEXT,cpdt TEXT,op TEXT,opdt TEXT,specification TEXT,minPackUnit TEXT,minTagUnit TEXT,tagPackRatio TEXT,tagRatio TEXT,toProvince TEXT,toUnit TEXT,isfile INTEGER)";
        sqLiteDatabase.execSQL(sqlStr);

        // 创建 billdetail 表
        sqlStr = "CREATE TABLE billdetail (flowid TEXT,code TEXT,codetype INTEGER,cpid TEXT)";
        sqLiteDatabase.execSQL(sqlStr);

        // 创建 cpinfo表
        sqlStr = "CREATE TABLE cpinfo (gg text,itemid text,pzrq text,pzwh text,qyid text,qyname text,spm text,tym text,gg_new TEXT,minPackUnit text,minTagUnit text,tagPackRatio text,tagRatio text)";
        sqLiteDatabase.execSQL(sqlStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
