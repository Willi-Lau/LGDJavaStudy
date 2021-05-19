package com.lwy.study202105.java;

/**
 * 学习类加载顺序
 * @time 20210519 22:47
 */
public class JavaExtends {
    public  int test = this.test();
    public static int method = method();

    static{
        System.out.print("11 ");
    }
    JavaExtends(){
        System.out.print("12 ");
    }
    {
        System.out.print("13 ");
    }
    public int test(){
        System.out.print("14 ");
        return 1;
    }

    public static int method(){
        System.out.print("15 ");
        return 1;
    }
    public static void main(String[] args) {
        Son s = new Son();
    }
}

class Father{
    public  int test = this.test();
    public static int method = method();

    static{
        System.out.print("1 ");
    }
    Father(){
        System.out.print("2 ");
    }
    {
        System.out.print("3 ");
    }
    public int test(){
        System.out.print("4 ");
        return 1;
    }

    public static int method(){
        System.out.print("5 ");
        return 1;
    }
}

class Son extends Father{
    public  int test = this.test();
    public static int method = method();

    static{
        System.out.print("6 ");
    }
    Son(){
        System.out.print("7 ");
    }
    {
        System.out.print("8 ");
    }
    public int test(){
        System.out.print("9 ");
        return 1;
    }

    public static int method(){
        System.out.print("10 ");
        return 1;
    }


}


