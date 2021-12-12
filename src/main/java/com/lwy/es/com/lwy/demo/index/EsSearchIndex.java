package com.lwy.es.com.lwy.demo.index;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class EsSearchIndex {
    public static void main(String[] args) throws IOException {

        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest("shopping1");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        //返回结果
        System.out.println(response.getAliases());
        Map<String, MappingMetadata> mappings = response.getMappings();
        mappings.forEach((x,y)->{
            y.getSourceAsMap().forEach((x1,y1)->{
                System.out.println(x1 + " " + y1.toString());
            });
        });
        System.out.println(response.getSettings());
        // 关闭客户端连接
        client.close();
    }
}
