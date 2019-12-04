package com.atstudy.day01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class formatStringTest {
    public static void main(String[] args) {
        formatString fs = new formatString();
        System.out.println(fs.getStr()+"   "+fs.getStr2());
    }
}
class formatString{
    private String str;
    private String str2;

    public formatString() {
    }
//    public formatString(String str) {
//        this.str = str;
//    }

    public String getStr(){
        Calendar c = Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int date = c.get(c.DAY_OF_MONTH);
        int hour = c.get(c.HOUR_OF_DAY);
        int minute = c.get(c.MINUTE);
        int scond = c.get(c.SECOND);
        str = year+"-"+month+"-"+date+"-"+hour+"-"+minute+"-"+scond;
        return str;
    }

    public String getStr2(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        str2 = format.format(date);
        return str2;
    }

}
