package com.lwy.invoke;

class Person {
    String name;
    String ID;
    int age;

    public Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public void show(){

        System.out.println("123");

    }
}

class Student extends Person{
    String name;
    String ID;
    int age,xh;


    public Student(String name, String ID, int age,int xh) {
        super(name, ID, age);
        this.xh = xh;
    }
}
