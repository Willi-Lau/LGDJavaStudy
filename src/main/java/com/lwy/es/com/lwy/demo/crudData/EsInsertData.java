package com.lwy.es.com.lwy.demo.crudData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwy.es.com.lwy.demo.entitys.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author Administrator
 */
public class EsInsertData {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引 - 请求对象
        IndexRequest indexRequest = new IndexRequest();
        //设置索引的名字
        indexRequest.index("happy").id("1001");
        //准备对象 然后转json
        User user = User.builder().age(11).name("张三").sex("男").build();
        //user 转 json
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        // XContentType.JSON 格式为json
        indexRequest.source(userJson, XContentType.JSON);
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        //结果
        System.out.println(response.getResult());
        // 关闭客户端连接
        client.close();
    }
}
