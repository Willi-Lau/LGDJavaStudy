package com.lwy.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Redis常用命令
 */
public class RedisTestApi {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //设置密码
        jedis.auth("12345");
        //set get
        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));
        //查找所有key
        System.out.println(jedis.keys("*"));
        //设置 读取list 不存在创建 存在追加
        jedis.rpush("list1","1","2","3","4","5");
        System.out.println(jedis.lrange("list1",0,-1));
        //返回链表长度
        System.out.println(jedis.llen("list1"));
        //创建字符串
        jedis.set("str01","1");
        //++
        jedis.incr("str01");
        //读取
        System.out.println(jedis.get("str01"));
        //加指定num
        jedis.incrBy("str01",100);
        System.out.println(jedis.get("str01"));
        //创建hash
        jedis.hset("person1","name","张三");
        System.out.println(jedis.hget("person1","name"));
        //增加属性
        jedis.hset("person1","age","12");
        System.out.println(jedis.hget("person1","age"));
        //多个增加
        HashMap<String, String> map = new HashMap<>();
        map.put("name","李四");
        map.put("age","12");
        map.put("inf","aaaa");
        jedis.hmset("person2",map);

        //读取多个
        Map<String, String> person2 = jedis.hgetAll("person2");
        person2.forEach((k,v)->{
            System.out.println(k+"   "+v);
        });

        //设置事务
        Transaction multi = jedis.multi();
        //事务的提交
        multi.set("str011","1");
        multi.set("str0111","1");
        multi.set("str01111","1");
        //提交
        multi.exec();
        jedis.set("strk","11111111");
        //事务2 不提交
        Transaction multi1 = jedis.multi();
        multi1.set("strk","hahaha");
        multi1.set("dashabi","chx");
        multi1.discard();

        System.out.println(jedis.get("strk"));

        //事务监听
        int money = 100;
        Transaction multi2 = jedis.multi();

        multi2.set("money",Integer.toString(money));
        jedis.watch("money");
        money = 30;
        multi2.set("money",Integer.toString(money));
        //这里会停止提交事务
        if(money < 50){
            jedis.unwatch();
        }


        multi2.exec();
        //这里会触发 NullPointerException 因为前面watch失败 事务没有成功提交
        System.out.println(jedis.get("money"));

        //池子的使用
        //建立对象
        Jedis jedis1 = null;
        //获取池子
        JedisPool pool = JedisPoolUtil.getJedisPool();
        //获取连接
        try {
            jedis1 = pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退回给池子
            JedisPoolUtil.release(pool,jedis1);
        }


    }
}

/**
 * 单例Jedis池 线程安全
 */

class JedisPoolUtil{
    private static volatile JedisPool jedisPoolutil = null;
    private  JedisPoolUtil (){};
    //实例化
    public static JedisPool getJedisPool(){
        if(jedisPoolutil == null){
            synchronized (JedisPoolUtil.class){
                if(jedisPoolutil == null){
                    //jedis 池配置 保证返回的永远是一个池
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    //最大连接数  老版本是setMaxActive
                    jedisPoolConfig.setMaxTotal(1000);
                    //最多空闲数
                    jedisPoolConfig.setMaxIdle(32);
                    //最大等待时间 毫秒
                    jedisPoolConfig.setMaxWaitMillis(100*1000);
                    //获取Redis示例时是否检查可用性
                    jedisPoolConfig.setTestOnBorrow(true);


                    jedisPoolutil = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
                }
            }
        }


        return jedisPoolutil;
    }
    //执行退回 池子的东西用完了还要退回去  退回哪个池子那个对象
    public static void release(JedisPool jedisPool,Jedis jedis){
        //不是空再执行
        if(null != jedis){
            //这里close() 代替了  jedisPool.returnBrokenResource();
            //关闭连接
            jedis.close();
        }
    }

}

