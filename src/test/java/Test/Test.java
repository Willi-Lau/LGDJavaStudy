package Test;

import java.util.*;

public class Test {


    public static void main(String[] args) {
     List list =  new ArrayList();

     for (int i=0;i<=10;i++){
         new Thread(()->{
             list.add(UUID.randomUUID().toString().substring(0,8));
             System.out.println(Thread.currentThread().getName()+list);
         },Integer.toString(i)).start();
     }





    }

}
