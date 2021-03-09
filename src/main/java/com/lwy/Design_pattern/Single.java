package com.lwy.Design_pattern;

/**
 * 单例模式
 */
public class Single {
}

/**
 * 线程安全的单例模式
 */
class Person1{
    private static volatile Person1 person1 = null;
    private Person1 (){}

    public static Person1 getPersonInstance(){

        if(person1 == null){
            synchronized (Person1.class){
                if(person1 == null){
                    person1 = new Person1();
                }
            }
        }


        return person1;
    }

}
