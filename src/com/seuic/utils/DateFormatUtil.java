package com.seuic.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatUtil {
    
    private static final String  DEFAULT_PATTEN = "yyyy-MM-dd" ;
    
    public static String fomatDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_PATTEN , Locale.getDefault());
        return format.format(date);
    }
    
    public static Date ToDate(String stringdate){
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_PATTEN , Locale.getDefault());
        try {
            date = format.parse(stringdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
