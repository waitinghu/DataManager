package com.seuic.data;

import com.seuic.entities.BillDetail;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BillDetailDao {

    private DataBaseHelper billdetailDB;

    public BillDetailDao(Context context) {
        billdetailDB = new DataBaseHelper(context);
    }

    // 增加数据
    public void Add(BillDetail billDetail) {
        SQLiteDatabase db = billdetailDB.getWritableDatabase();
        String sqlStr = "insert into billdetail(flowid,code,codetype,cpid) values(?,?,?,?)";
        db.execSQL(sqlStr, new String[] { billDetail.getFlowid(), billDetail.getCode(), billDetail.getCodetype()+"", billDetail.getCpid() });
        // db.close();
    }

    // 查询一条数据
    public BillDetail QueryOneRecord(String flowid) {
        SQLiteDatabase db = billdetailDB.getReadableDatabase();
        BillDetail billDetail = null;
        String sqlStr = "SELECT * FROM billdetail where flowid = ?";
        Cursor cursor = db.rawQuery(sqlStr, new String[]{flowid});
        if(cursor != null && cursor.moveToFirst()) {
            billDetail = new BillDetail();
            billDetail.setCode(cursor.getString(cursor.getColumnIndex("code")));
            billDetail.setCodetype(cursor.getInt(cursor.getColumnIndex("codetype")));
            billDetail.setCpid(cursor.getString(cursor.getColumnIndex("cpid")));
            billDetail.setFlowid(cursor.getString(cursor.getColumnIndex("flowid")));
        }
        return billDetail;
    }

    // 删除所有数据
    public void DeleteAll() {
        SQLiteDatabase db = billdetailDB.getWritableDatabase();
        String sqlStr = "delete FROM billdetail";
        db.execSQL(sqlStr);

        // 序列号清零
        sqlStr = "DELETE FROM sqlite_sequence WHERE name = 'billdetail'";
        db.execSQL(sqlStr);
        // db.close();
    }

}
