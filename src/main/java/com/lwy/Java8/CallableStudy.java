package com.lwy.Java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//实现 Callable 接口。有返回值
class CallableThread implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        System.out.println("Callable begin");
        return 14;
    }
}

public class CallableStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Callable 的实现
        FutureTask <Integer> futureTask = new FutureTask(new CallableThread());
        //通过Thread 执行
        new Thread(futureTask,"a").start();
        //返回接受值
        Integer i = futureTask.get();
        System.out.println(i);



    }
}
