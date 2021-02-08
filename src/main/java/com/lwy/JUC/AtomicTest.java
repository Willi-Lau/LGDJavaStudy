package com.lwy.JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        i.compareAndSet(1,2);

        i.addAndGet(10);
        System.out.println(i.get());

    }
}
