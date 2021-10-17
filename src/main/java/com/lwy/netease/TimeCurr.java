package com.lwy.netease;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCurr {

    public static void main(String[] args) {
       // long currentTime  = Long.parseLong( "1633966200000"+"l");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
        Date date = new Date(1633966200000l);
        System.out.println(formatter.format(date));


    }
}
