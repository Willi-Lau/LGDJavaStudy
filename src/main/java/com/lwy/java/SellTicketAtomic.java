package com.lwy.java;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SellTicketAtomic {
    public static void main(String[] args) {
       List list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4);
        for (Object o : list) {
            o = 5;
        }
        list.forEach(System.out::println);

    }

    static void show(String a,String b){
        a = "1";
        b = a;
    }
}


class SellTicket{

    public volatile AtomicInteger i = new AtomicInteger(100);

    public  synchronized void sell(){
        ConcurrentHashMap map = new ConcurrentHashMap();
        if(i.get()>0) {
            int m = i.get();
            System.out.println(Thread.currentThread().getName() + "卖了第" + m  + "张票");
            if(m == i.get()){
                i.compareAndSet(m , m - 1);
            }
            else {

            }

        }
    }


}
