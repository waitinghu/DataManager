package com.seuic.data;

import java.util.ArrayList;

import com.seuic.entities.Bill;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BillDao {

    private DataBaseHelper billDB;
    
    public BillDao(Context context){
        billDB = new DataBaseHelper(context);
    }

    //增加数据
    public void addBill(Bill bill){
        SQLiteDatabase db = billDB.getWritableDatabase();
        String sqlStr="insert into bill(flowid,srvtype,cpid,batchno,cpdt,op,opdt,specification,minPackUnit" +
                ",minTagUnit,tagPackRatio,tagRatio,toProvince,toUnit,isfile) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        db.execSQL(sqlStr,new String[]{bill.getFlowid(),bill.getSrvtype()+"",bill.getCpid(),bill.getBatchno(),bill.getCpdt(),bill.getOp(),bill.getOpdt()
                ,bill.getSpecification(),bill.getMinPackUnit(),bill.getMinTagUnit(),bill.getTagPackRatio(),bill.getTagRatio(),bill.getToProvince(),bill.getToUnit(),bill.getIsfile()+""});
    }
    
    
    public ArrayList<Bill> getAllBills () {
        ArrayList<Bill> bills = new ArrayList<Bill>();
        SQLiteDatabase db = billDB.getReadableDatabase();
        String sql=" SELECT * FROM bill";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            Bill bill = new Bill();
            bill.setFlowid(cursor.getString(cursor.getColumnIndex("flowid")));
            bill.setSrvtype(cursor.getInt(cursor.getColumnIndex("srvtype")));
            bill.setCpid(cursor.getString(cursor.getColumnIndex("cpid")));
            bill.setBatchno(cursor.getString(cursor.getColumnIndex("batchno")));
            bill.setCpdt(cursor.getString(cursor.getColumnIndex("cpdt")));
            bill.setOp(cursor.getString(cursor.getColumnIndex("op")));
            bill.setOpdt(cursor.getString(cursor.getColumnIndex("opdt")));
            bill.setSpecification(cursor.getString(cursor.getColumnIndex("specification")));
            bill.setMinPackUnit(cursor.getString(cursor.getColumnIndex("minPackUnit")));
            bill.setMinTagUnit(cursor.getString(cursor.getColumnIndex("minTagUnit")));
            bill.setTagPackRatio(cursor.getString(cursor.getColumnIndex("tagPackRatio")));
            bill.setTagRatio(cursor.getString(cursor.getColumnIndex("tagRatio")));
            bill.setToProvince(cursor.getString(cursor.getColumnIndex("toProvince")));
            bill.setToUnit(cursor.getString(cursor.getColumnIndex("toUnit")));
            bill.setIsfile(cursor.getInt(cursor.getColumnIndex("isfile")));
            bills.add(bill);
        }
        return bills;
    }
    
    

    //查询一条数据
    public Bill QueryOneRecord(String flowid){
        Bill bill = null;
        SQLiteDatabase db = billDB.getReadableDatabase();
        String sqlStr=" SELECT * FROM bill where flowid = ? ";
        Cursor cursor = db.rawQuery(sqlStr,new String[]{flowid});
        if(cursor != null && cursor.moveToFirst()) {
            bill = new Bill();
            bill.setFlowid(cursor.getString(cursor.getColumnIndex("flowid")));
            bill.setSrvtype(cursor.getInt(cursor.getColumnIndex("srvtype")));
            bill.setCpid(cursor.getString(cursor.getColumnIndex("cpid")));
            bill.setBatchno(cursor.getString(cursor.getColumnIndex("batchno")));
            bill.setCpdt(cursor.getString(cursor.getColumnIndex("cpdt")));
            bill.setOp(cursor.getString(cursor.getColumnIndex("op")));
            bill.setOpdt(cursor.getString(cursor.getColumnIndex("opdt")));
            bill.setSpecification(cursor.getString(cursor.getColumnIndex("specification")));
            bill.setMinPackUnit(cursor.getString(cursor.getColumnIndex("minPackUnit")));
            bill.setMinTagUnit(cursor.getString(cursor.getColumnIndex("minTagUnit")));
            bill.setTagPackRatio(cursor.getString(cursor.getColumnIndex("tagPackRatio")));
            bill.setTagRatio(cursor.getString(cursor.getColumnIndex("tagRatio")));
            bill.setToProvince(cursor.getString(cursor.getColumnIndex("toProvince")));
            bill.setToUnit(cursor.getString(cursor.getColumnIndex("toUnit")));
            bill.setIsfile(cursor.getInt(cursor.getColumnIndex("isfile")));
        }
        return bill;
    }

    //删除所有数据
    public  void DeleteAll(){
        SQLiteDatabase db = billDB.getWritableDatabase();
        String sqlStr="delete FROM bill";
        db.execSQL(sqlStr);
        //序列号清零
        sqlStr="DELETE FROM sqlite_sequence WHERE name = 'bill'";
        db.execSQL(sqlStr);
        //db.close();
    }
}
