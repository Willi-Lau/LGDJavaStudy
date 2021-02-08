package com.lwy.JVM;

class Demo{
    //int flag = 10;  //错误的定义  别的线程看不到值得改变
    volatile int flag = 10;
    public void addflag(){
        this.flag = 100;
    }
}


public class JMM_Volatile {
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"******come in");
            try {
                Thread.sleep(1000);
                demo.addflag();
                System.out.println(Thread.currentThread().getName()+"改变后的值"+demo.flag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"自定义线程1").start();




        //主线程
        while (true){
            if(demo.flag == 100){
            System.out.println("******检测到其他线程改变主内存数据");
            break;
            }

        }
    }
}
