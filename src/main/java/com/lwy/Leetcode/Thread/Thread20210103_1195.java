package com.lwy.Leetcode.Thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
import java.util.logging.Filter;

/**
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Thread20210103_1195 {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread a = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread b = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread c = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread d = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        a.start();
        b.start();
        c.start();
        d.start();

    }




}



class FizzBuzz {
    private int n;

    private Semaphore semaphore3 = new Semaphore(0);
    private Semaphore semaphore5= new Semaphore(0);
    private Semaphore semaphore35 = new Semaphore(0);
    private Semaphore semaphoren = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".   3
    public void fizz(Runnable printFizz) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 != 0){
                semaphore3.acquire();
                printFizz.run();
                semaphoren.release();

        }}

    }

    // printBuzz.run() outputs "buzz".   5
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if(i % 5 == 0 && i % 3 != 0){

                semaphore5.acquire();
                printBuzz.run();
                semaphoren.release();


        }}
    }

    // printFizzBuzz.run() outputs "fizzbuzz".  3  5
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if(i % 5 == 0 && i % 3 == 0){

                semaphore35.acquire();
                printFizzBuzz.run();
                semaphoren.release();

        }}

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i ++){
            semaphoren.acquire();
            if( i%3 == 0 && i%5 == 0){
                semaphore35.release();
            }
            else if(i%3 == 0 && i%5 != 0){
                semaphore3.release();
            }
            else if(i%5 == 0 && i%3 != 0){
                semaphore5.release();
            }
            else {
                printNumber.accept(i);
                semaphoren.release();
            }
        }


    }
}