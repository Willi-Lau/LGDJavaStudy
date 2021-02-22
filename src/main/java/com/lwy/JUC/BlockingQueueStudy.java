package com.lwy.JUC;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueStudy {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new ArrayBlockingQueue(3);  //有上限
        queue.add(10);
        queue.add(12);
        queue.add(13);
        //到这里已经添加3个元素了已经满了
        //再添加 设置阻塞超时
        queue.offer(18,3L, TimeUnit.SECONDS);


        //删除
        queue.remove();
        queue.remove();
        queue.remove();
        //删除 设置阻塞超时
        queue.poll(3,TimeUnit.SECONDS);
    }
}
