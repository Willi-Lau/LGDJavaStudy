package com.lwy.JUC;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockStudy {

    public static void main(String[] args) {
        ReadAndWrite rw = new ReadAndWrite();
        //五个线程读
        for (int i=0;i<5;i++){
            int finalI = i;
            new Thread(()->{
                rw.readHashMap(finalI);
            },"线程"+Integer.toString(i)).start();
        }
        //五个线程写
        for (int i=0;i<5;i++){
            int finalI = i;
            new Thread(()->{
                try {
                    rw.writeHashMMap(finalI,Integer.toString(finalI)+"嘿嘿额hi");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"线程"+Integer.toString(i)).start();
        }

    }
}


class ReadAndWrite{

     volatile HashMap<Integer,String> hashmap = new HashMap();

    //加入读写锁
    ReadWriteLock  lock = new ReentrantReadWriteLock();

    //写
    public void writeHashMMap(Integer key,String value) throws Exception {
        //选用读写锁的写入锁 并开启
        lock.writeLock().lock();

        try {
            System.out.println("正在写入 线程："+ Thread.currentThread().getName());
            hashmap.put(key,value);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("写入完成"+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭写入锁
            lock.writeLock().unlock();
        }
    };
    //读
    public void readHashMap(Integer key){
        //开启读写锁中的读锁
        lock.readLock().lock();

        try {
            System.out.println("开始读取");
            TimeUnit.SECONDS.sleep(1);
            String s = hashmap.get(key);
            System.out.println("读取成功"+s+"  线程："+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭读锁
            lock.readLock().unlock();
        }
    }




}
