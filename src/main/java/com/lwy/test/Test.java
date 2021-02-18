package com.lwy.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

interface Foo{
    public void speak();
}
public class Test {
    public static void main(String[] args) {

          Foo foo = new Foo() {              //普通实现
              @Override
              public void speak() {
                  System.out.println("sb");
              }
          };

            Foo foo2 = () ->{         //lambda
                System.out.println("sb");
            };

    }
}
