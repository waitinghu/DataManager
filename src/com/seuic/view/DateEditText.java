package com.seuic.view;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class DateEditText extends EditText {
    private Context mContext;
    private Calendar c;
    private int mYear;
    private int mMonth;
    private int mDay;
    private boolean datePickerEnabled = true;
    
    private onDateSetListener listener;
    public interface onDateSetListener {
        void onDateSet(View dateEditText ,Date date);
    };

    public DateEditText(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public DateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    
    public void setOnDateSetListener (onDateSetListener listener) {
        if(listener != null) {
            this.listener = listener;
        }
    }
    
    public DateEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    private void init(){
        c = Calendar.getInstance();
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);
        this.setEnabled(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            if (datePickerEnabled) {
                new DatePickerDialog(mContext,new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
                                mYear = year;
                                mMonth = monthOfYear;
                                mDay = dayOfMonth;
                                setText(new StringBuilder().append("")
                                        .append(mYear).append("-")
                                        .append(mMonth + 1).append("-")
                                        .append(mDay).append(""));
                                
                                if(listener != null) {
                                    Calendar cal = Calendar.getInstance();
                                    cal.set(year, monthOfYear, dayOfMonth);
                                    listener.onDateSet(DateEditText.this,cal.getTime());
                                }
                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        }
        return super.onTouchEvent(event);
    }

    public boolean isDatePickerEnabled() {
        return datePickerEnabled;
    }

    public void setDatePickerEnabled(boolean datePickerEnabled) {
        this.datePickerEnabled = datePickerEnabled;
        if (!datePickerEnabled) {
            setText("");
        }
    }
}