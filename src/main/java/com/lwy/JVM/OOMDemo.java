package com.lwy.JVM;

public class OOMDemo {
    public static void main(String[] args) {
        while (true){
            Object string = new StringGC();
            byte[] a = new byte[1024 * 1024];
        }
    }
}
