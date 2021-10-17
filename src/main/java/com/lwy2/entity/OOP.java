package com.lwy2.entity;


import com.lwy2.entity.Student;

/**
 * 引用更改
 */
public class OOP {
    public static void main(String[] args) throws CloneNotSupportedException  {
        Student s = new Student("lwy",21,new Son());
        Student b = s;

        b.setAge(100);
        System.out.println(s.getAge());
        System.out.println(s == b);


        /////////////////////////////////////

        Student dsp = new Student("dsp",22,new Son("张三"));
        Student dsp1 = (Student)dsp.clone();
        System.out.println(dsp == dsp1);
        System.out.println(dsp.getSon() == dsp1.getSon());


    }
}
