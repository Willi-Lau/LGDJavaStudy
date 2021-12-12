package com.lwy.es.com.lwy.demo.index;


import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;

import java.io.IOException;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class EsDeleteIndex {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引 - 请求对象
        DeleteIndexRequest request = new DeleteIndexRequest("user2");
        System.out.println(client.indices().delete(request, RequestOptions.DEFAULT));
        // 关闭客户端连接
        client.close();
    }
}
