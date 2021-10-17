package com.lwy2.wangyi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Test0917 {
    public  volatile static int flag = 0;  //不加volatile 会一直卡在while
    public static void main(String[] args) {
       String s1 = "012345";


        System.out.println(s1.substring(1,2));

    }






}


@AllArgsConstructor
@Data
class Person{
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}