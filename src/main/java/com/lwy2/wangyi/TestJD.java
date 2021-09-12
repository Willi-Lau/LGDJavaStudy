package com.lwy2.wangyi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**   https://www.nowcoder.com/discuss/740537?type=post&order=time&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack
 *  重点 都是单向管理
 * 一组机器 1 2 3刚开始都是关闭
 * 输入描述
 * 3    三组依赖
 * 1 2   1号机器依赖一个 2   1开启 2就开启    1关闭 2不关闭   2关闭 1关闭
 * 1 3   2号机器依赖一个 3   2开启 3就开启    2关闭 3不关闭
 * 0     3号机器谁也不依赖
 * 2    两组操作  1开启 2 睡眠
 * 1 1  开启  1号
 * 0 2  关闭 2号
 *
 *
 *
 * 输出
 * 3   开启 1 -》 2 -》 3
 * 1   关闭 2 -》 1
 *     关闭时候 3 不受影响
 *
 */
public class TestJD {
    static LinkedList<Integer>[] depend = null;
    static LinkedList<Integer>[] undepend = null;
    static HashSet<Integer> set = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();    // 3
        depend = new LinkedList[num+1];
        undepend = new LinkedList[num+1];
        set = new HashSet<>();

        for(int i=1;i<num+1;i++){
            depend[i] = new LinkedList<>();
            undepend[i] = new LinkedList<>();
        }
        for (int i=1;i<num+1;i++){
            int now = sc.nextInt();
            for(int j=0;j<now;j++){
                int kw = sc.nextInt();
                depend[i].add(kw);
                undepend[kw].add(i);
            }

        }

        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int sleep = sc.nextInt();
            int linux = sc.nextInt();
            if(sleep == 0){
                stop(linux);
            }
            else {
                start(linux);
            }
            set.forEach((x)->{
                System.out.println("机器"+x+"存活" +"此次执行"+(sleep == 1? "开启" : "关闭"));
            });
            System.out.println(set.size());
        }
    }

    public static void  start(int num){
        set.add(num);
        LinkedList<Integer> linkedList = depend[num];  //依赖表
        if(linkedList != null){
           for (int i:linkedList){
               if(!set.contains(i))
                    start(i);
           }
        }
    }

    public static void  stop(int num){
        set.remove(num);
        LinkedList<Integer> linkedList = undepend[num];  //依赖表
        if(linkedList != null){
            for (int i:linkedList){
                if(set.contains(i))
                    stop(i);
            }
        }
    }
}
