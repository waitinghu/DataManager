package com.seuic.datamanager;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import com.seuic.data.BillDao;
import com.seuic.data.BillDetailDao;
import com.seuic.entities.Bill;
import com.seuic.entities.Product;
import com.seuic.entities.XMLData;
import com.seuic.listgrid.GridColumn;
import com.seuic.listgrid.ListGrid;
import com.seuic.listgrid.ListGrid.ColumnType;
import com.seuic.listgrid.ListGrid.ListRow;
import com.seuic.utils.XMLProducer;
import com.seuic.view.DateEditText;
import com.seuic.view.DateEditText.onDateSetListener;


public class DataMgActivity extends Activity implements OnClickListener ,OnCheckedChangeListener, onDateSetListener {
    
    private RelativeLayout mList_grid_containner;
    private CheckBox mAll_select;
    private CheckBox mAlready_generate;
    private Button mDelete;
    private Button mGenerateFlie;
    private DateEditText mStartDate;
    private DateEditText mEndDate;
    private float mDensity;
    protected ListGrid mGrid;
    
    private BillDao mBillDao;
    private BillDetailDao mBillDetailDao;
    
    private Date mStart_Date;
    private Date mEnd_Date;
    
    private boolean isFileChecked;
    private ArrayList<Bill> bills;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDensity = getDensity();
        setContentView(R.layout.activity_data_mg);
        mBillDao = new BillDao(this);
        mBillDetailDao = new BillDetailDao(this);
        mStartDate = (DateEditText) findViewById(R.id.start);
        mStartDate.setOnDateSetListener(this);
        mEndDate = (DateEditText) findViewById(R.id.end);
        mEndDate.setOnDateSetListener(this);
        
        mAll_select = (CheckBox) findViewById(R.id.all_select_check);
        mAll_select.setOnCheckedChangeListener(this);
        
        mAlready_generate = (CheckBox) findViewById(R.id.already_file_check);
        mAlready_generate.setOnCheckedChangeListener(this);
        
        mGenerateFlie = (Button) findViewById(R.id.btn_generate_file);
        mGenerateFlie.setOnClickListener(this);
        
        mDelete = (Button) findViewById(R.id.btn_delete);
        mDelete.setOnClickListener(this);
        
        mList_grid_containner = (RelativeLayout) findViewById(R.id.data_list_containner);
        
        List<GridColumn> columns = new ArrayList<GridColumn>();
        columns.add(new GridColumn("产品名称", (int)(100 * mDensity)));
        columns.add(new GridColumn("批次", (int)(100 * mDensity)));
        columns.add(new GridColumn("入库日期", (int)(60 * mDensity)));
        columns.add(new GridColumn("入库数量", (int)(80 * mDensity)));
        columns.add(new GridColumn("条码总数", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        columns.add(new GridColumn("任务号", (int)(150 * mDensity)));
        mGrid = new ListGrid(this, columns, ColumnType.WIDTH);
        mGrid.setHeaderTextSize(14);
        mGrid.setCellTextSize(12);
        mGrid.setFullRowSelect(true);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mGrid.setPadding(0, 0, 0, 0);
        mGrid.setLayoutParams(lp);
        mList_grid_containner.addView(mGrid);
        
        bills = mBillDao.getAllBills();
        flashListGrid();
        
    }
    
    
    // 屏幕像素密度
    private float getDensity() {
        WindowManager manager = getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.density;
    }

    @Override
    public void onClick(View v) {
        
        int id = v.getId();
        if(id == R.id.btn_delete) {
            List<ListRow> rows = mGrid.getAllRows();
            for (int i = 0; i < rows.size(); i++) {
                ListRow row = rows.get(i);
                if(row.isRowSelect()) {
                    mGrid.removeRow(i);
                }
            }
        } else if(id == R.id.btn_generate_file) {
            
            ArrayList<String> codes = new ArrayList<String>();
            ArrayList<Product> products = new ArrayList<Product>();
            codes.add("201401160000100923550993");
            codes.add("201401160000100923550993");
            codes.add("201401160000100923550993");
            codes.add("201401160000100923550993");
            Product product = new Product("猪伪狂犬病活疫苗（HB－98 株）", "兽药生字（2011）170041056", 
                    "140619", "10头份", 
                    "甁", "盒", "10", "1:50", "2014/06/06", 
                    "科前PDA管理员", "2014/09/09", "0", "0", codes);
            products.add(product);
            products.add(product);
            XMLData data = new XMLData("武汉科前动物生物制品有限责任公司", "wareHouseIn", "1.0",
                    "http://www.w3.org/2001/XMLSchema-instance", "兽药产品入库数据_生产企业.xsd", products);
            String ss  = Environment.getExternalStorageDirectory() + File.separator + "ssss.xml";
            genrateFile(data,ss);
        }
        
    }

    private boolean genrateFile(XMLData data,String path) {
        return XMLProducer.generateXMLFile(path, data);
    }
    
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
        case R.id.all_select_check:
            mGrid.setAllRowsSelect(isChecked);
            break;
        case R.id.already_file_check:
            isFileChecked = isChecked;
            flashListGrid();
            break;
        default:
            break;
        }
        
    }

    @Override
    public void onDateSet(View dateEditText, Date date) {
        int id = dateEditText.getId();
        switch (id) {
        case R.id.start:
            mStart_Date = date;
            break;
        case R.id.end:
            mEnd_Date = date;
            break;
        default:
            break;
        }
        checkCondition();
    }

    private void checkCondition() {
        if(mStart_Date != null && mEnd_Date != null) {
            if(mStart_Date.before(mEnd_Date)) {
                flashListGrid();
            } else {
                Toast.makeText(this, "结束日期必须大于开始日期", Toast.LENGTH_SHORT).show();
            }
        }
    }
    
    private void flashListGrid() {
        mGrid.clearRows();
        List<ListRow> ss = new ArrayList<ListGrid.ListRow>();
        for(Bill bill : bills) {
            if(isFileChecked) {
                if(bill.getIsfile() == 0) {
                    continue;
                }
            }
            ListRow row = mGrid.newRow();
            row.setValue(0, bill.getFlowid());;
            row.setValue(1, bill.getSrvtype()+"");;
            row.setValue(2, bill.getCpid());;
            row.setValue(3, bill.getBatchno());;
            row.setValue(4, bill.getCpdt());;
            row.setValue(5, bill.getOp());;
            row.setValue(6, bill.getOpdt());;
            row.setValue(7, bill.getSpecification());;
            row.setValue(8, bill.getMinPackUnit());;
            row.setValue(9, bill.getMinTagUnit());;
            row.setValue(10, bill.getTagPackRatio());;
            row.setValue(11, bill.getTagRatio());;
            row.setValue(12, bill.getToProvince());;
            row.setValue(13, bill.getToUnit());;
            row.setValue(14, bill.getIsfile()+"");
            ss.add(row);
        }
        mGrid.insertRows(ss);
        
    }

}
