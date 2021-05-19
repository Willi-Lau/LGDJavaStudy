package com.lwy.study202105.java;

import sun.nio.cs.ext.MacArabic;

public class JavaExtends2 {
    public static void main(String[] args) {
            S s = new S(1);
    }
}

class F{
    private int i;

//    public F(int i) {
//        this.i = i;
//        System.out.println("f 有");
//    }

    public F() {
        System.out.println("f 无");
    }
}
class S extends F{
    private int i;
    public S(int i) {
        //super(i);
        this.i = i;
        System.out.println("s 有");
    }

    public S() {
        System.out.println("s 无");
    }
}
