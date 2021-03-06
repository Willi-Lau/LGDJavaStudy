package com.lwy.Redis;

import redis.clients.jedis.Jedis;

/**
 * 测试Redis连通性
 */
public class Redis01 {
    public static void main(String[] args) {
        //填写Redis连接参数
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //设置密码
        jedis.auth("12345");
        System.out.println(jedis.ping());
    }
}
