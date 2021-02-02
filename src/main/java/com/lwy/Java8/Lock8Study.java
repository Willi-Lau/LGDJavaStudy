package com.lwy.Java8;


import java.util.concurrent.TimeUnit;

class  Phone{
    public  synchronized void sellemail() throws Exception{
        TimeUnit.SECONDS.sleep(4);   //线程睡眠4秒
        System.out.println("******sellemail");

    }
    public  synchronized void getemail() throws Exception{
        System.out.println("******getemail");

    }


}

public class  Lock8Study {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.getemail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"a").start();


        new Thread(()->{
            try {
                phone.sellemail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b").start();
    }

}
