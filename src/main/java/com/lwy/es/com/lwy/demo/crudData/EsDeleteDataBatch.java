package com.lwy.es.com.lwy.demo.crudData;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author liuweiyi
 * @Time 2021/12/29
 */
public class EsDeleteDataBatch {
    public static void main(String[] args) throws Exception{
        // 创建客户端对象wq
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        //批量新增 批量删除
        BulkRequest bulkRequest = new BulkRequest();
        //新增的每一条
        DeleteRequest zhangSan = new DeleteRequest().index("happy").id("1002");
        DeleteRequest liSi = new DeleteRequest().index("happy").id("1003");
        DeleteRequest wangWu = new DeleteRequest().index("happy").id("1004");

        bulkRequest.add(zhangSan);
        bulkRequest.add(liSi);
        bulkRequest.add(wangWu);
        //返回结果
        BulkResponse responses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(responses);
        // 关闭客户端连接m ,s
        client.close();
    }
}
