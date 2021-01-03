package com.lwy.Java8;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticketinf {

    private int number_tick = 100;

    Lock lock = new ReentrantLock();

    public void sellticket(){
            lock.lock();
            try{
                if(number_tick >0){
                System.out.println(Thread.currentThread().getName()+"卖出第"+number_tick+"票");
                number_tick -- ;}
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }


    }


}



public class LockStudy {


    public static void main(String[] args) {
        Ticketinf ticket = new Ticketinf();

        for(int i=1;i<4;i++){
            //lambda 表达式
            new Thread(()->{ for(int a=1;a<100;a++) ticket.sellticket();},Integer.toString(i)).start();

        }

    }
}
