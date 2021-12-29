package com.lwy.es.com.lwy.demo.crudData;

import com.lwy.es.com.lwy.demo.entitys.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Map;

/**
 * @author Administrator
 */
public class EsGetData {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象wq
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引 - 请求对象
        GetRequest getRequest = new GetRequest();
        getRequest.index("happy").id("1001");
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        //结果封装到map里 可以转为对象
        Map<String, Object> map = response.getSourceAsMap();
        map.forEach((x,y)->{
            System.out.println(x+" "+y);
        });
        //结果
        System.out.println(response.getSourceAsString());
        // 关闭客户端连接m ,s
        client.close();
    }
}
