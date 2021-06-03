package com.lwy.JVM;

public class StringGC {
    public static void main(String[] args) {
        String str1="abcde";
        String str2= str1.substring (4);
        String str3=new String (str2);
        String str4=new String (str2.toCharArray ());
        System.gc();
    }
}
