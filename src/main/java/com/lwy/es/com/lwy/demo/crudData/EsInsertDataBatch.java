package com.lwy.es.com.lwy.demo.crudData;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.util.Map;

/**
 * @author liuweiyi
 * @Time 2021/12/29
 */
public class EsInsertDataBatch {
    public static void main(String[] args) throws Exception{
        // 创建客户端对象wq
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        //批量新增 批量删除
        BulkRequest bulkRequest = new BulkRequest();
        //新增的每一条
        IndexRequest zhangSan = new IndexRequest().index("happy").id("1002").source(XContentType.JSON, "name", "张三","age",15);
        IndexRequest liSi = new IndexRequest().index("happy").id("1003").source(XContentType.JSON, "name", "李四","age",19);
        IndexRequest wangWu = new IndexRequest().index("happy").id("1004").source(XContentType.JSON, "name", "王五","age",11);
        IndexRequest m1 = new IndexRequest().index("happy").id("1005").source(XContentType.JSON, "name", "刘伟艺","age",12);
        IndexRequest m2 = new IndexRequest().index("happy").id("1006").source(XContentType.JSON, "name", "董世苹","age",14);
        IndexRequest m3 = new IndexRequest().index("happy").id("1007").source(XContentType.JSON, "name", "李金泽","age",13);

        bulkRequest.add(zhangSan);
        bulkRequest.add(liSi);
        bulkRequest.add(wangWu);
        bulkRequest.add(m1);
        bulkRequest.add(m2);
        bulkRequest.add(m3);

        //返回结果
        BulkResponse responses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(responses);
        // 关闭客户端连接m ,s
        client.close();
    }
}
