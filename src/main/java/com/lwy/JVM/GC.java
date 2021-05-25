package com.lwy.JVM;

import java.util.concurrent.TimeUnit;

/**
 * 测试GC
 * jps -l 查看进程号
 * jinfo -flag ** 端口号       查看此次JVM是否打开指定功能
 *      e.g.  jinfo -flag PrintGCDetails 17840  查看是否开启GC日志  ——>    -XX:-PrintGCDetails    -XX:后面是减号 说明没开启
 */
public class GC {
    public static void main(String[] args) throws Exception{
        System.out.println("hello world");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
