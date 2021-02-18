package com.lwy.JUC;


import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
     int num = 1000;
    Lock lock = new ReentrantLock();
    public void sell(){
        lock.lock();
                try {
                    while (num >0){
                    System.out.println(Thread.currentThread().getName()+"卖出第"+num+"张票");
                    num --;
                   }
                    

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
        }
}
public class TicketExample {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i=0;i<13;i++){
            new Thread(()->{
                for (;;){
                    if(ticket.num ==0){
                        break;
                    }
                    ticket.sell();
                }
            },"线程"+i).start();
        }
    }
}
