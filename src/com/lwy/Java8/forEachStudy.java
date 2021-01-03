package com.lwy.Java8;

import java.util.ArrayList;
import java.util.List;

public class forEachStudy {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        //
        list.forEach(System.out::println);

//        以上 等同于

        list.forEach((s)->{ System.out.println(s); });
    }


}
