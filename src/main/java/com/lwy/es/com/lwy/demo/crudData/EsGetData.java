package com.lwy.es.com.lwy.demo.crudData;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author Administrator
 */
public class EsGetData {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引 - 请求对象
        UpdateRequest updateRequest = new UpdateRequest();
        //设置索引的名字
        updateRequest.index("happy").id("1001");
        //修改的内容
        updateRequest.doc(XContentType.JSON,"sex","女");
        UpdateResponse update = client.update(updateRequest, RequestOptions.DEFAULT);

        //结果
        System.out.println(update.getResult());
        // 关闭客户端连接
        client.close();
    }
}
