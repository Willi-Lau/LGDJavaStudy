package com.lwy.es.com.lwy.demo.crudData;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author liuweiyi
 */
public class EsDeleteData {
    public static void main(String[] args) throws Exception{
        // 创建客户端对象wq
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        //设置删除的 index
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("happy").id("10001");
        //执行删除
        client.delete(deleteRequest, RequestOptions.DEFAULT);
        // 关闭客户端连接m ,s
        client.close();
    }
}
