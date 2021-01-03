package com.lwy.Java8;

import java.sql.Timestamp;
import java.util.Calendar;

public class Date {

    public static void main(String[] args) {
        Calendar cal=Calendar.getInstance();


        Timestamp time3 = new Timestamp(Calendar.getInstance().getTimeInMillis());


        System.out.println(time3);//获取系统当前时间

    }
}
