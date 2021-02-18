package com.lwy.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Integerandint {
    public static void main(String[] args) {
        int[] arr = {1,5,3,7,9};
        Integer[] arr1 = {1,5,6,5,4,7,8};
        List<Integer> integerList = new CopyOnWriteArrayList<>();
        Collections.addAll(integerList,1,2,3,34,4,4,4,4);


        // int[] 转 Integer[]
        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        //Integer[] 转 int[]
        int[] ints1 = Arrays.stream(arr1).mapToInt(Integer::valueOf).toArray();

        //List<Integer> 转 int[]
        int[] ints = integerList.stream().mapToInt(Integer::valueOf).toArray();
        // int[] 转 List<Integer>
        List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.toList());



        //Integer[] 转 List<Integer>
        List<Integer> integers1 = Arrays.asList(arr1);
        List<Integer> collect = Arrays.stream(arr1).collect(Collectors.toList());
        //List<Integer> 转 Integer[]
        Integer[] objects = integerList.toArray(new Integer[0]);

    }

    public void speak(String s){
        System.out.println(s);
    }
}
