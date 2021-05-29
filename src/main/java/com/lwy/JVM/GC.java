package com.lwy.JVM;

import java.util.concurrent.TimeUnit;

/**
 * 测试GC
 * jps -l 查看进程号
 * jinfo -flag ** 端口号       查看此次JVM是否打开指定功能
 * jinfo -flags  端口号       查看此次JVM是否打开所有功能
 *      e.g.  jinfo -flag PrintGCDetails 17840  查看是否开启GC日志  ——>    -XX:-PrintGCDetails    -XX:后面是减号 说明没开启
 *      常用jvm 参数（可以在idea里设置）：  -- 可以用这个设置heap大小等提提高微服务工作能力
 *         查看运行中java程序的指定jvm参数值
 *         jps -l 查看进程号
 *         jinfo -flag 类型 进程号   e.g.  jinfo -flag PrintGCDetails 17840
 *         jinfo -flags 进程号 查看所有的运行模块
 *
 *         k v 型：
 *             -XX:MetaspaceSize = ***  元空间大小
 *             -XX:MaxTenuringThreshold = *** 新生代 ->养老区需要经过多少次淘汰 默认值 15
 *
 *         boolean型：
 *             -XX:-PrintGCDetails  没开启GC日志 -XX:后面是 + 则开启 -则关闭
 *
 *         坑：
 *             -Xms 等价于 -XX:InitialHeapSize
 *             -xmx 等价于 -XX:MaxHeapSize
 *
 *         IDEA里设置jvm参数：
 *             Run -> Edit Configurations -> 选择类 -> 在 VM options里面设置jvm 参数
 *
 *         查看所有的jvm家底 包括自己设置的和默认值的：
 *             java -XX:+PrintFlagsInitial
 *  查看默认GC收集器：    java -XX:+PrintCommandLineFlags -version
 */
public class GC {
    public static void main(String[] args) throws Exception{
        System.out.println("hello world");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
