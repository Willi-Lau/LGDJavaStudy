package com.lwy.es.com.lwy.demo.crudData;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.naming.directory.SearchResult;
import java.io.IOException;

/**
 * @Author liuweiyi
 * 全量查询
 */
public class EsGetDataQuery {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引 - 请求对象
        SearchRequest searchRequest = new SearchRequest();
        //设置索引名字
        searchRequest.indices("happy");
        //设置查询条件 这里的是查询所有
        SearchRequest sources = searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        //执行
        SearchResponse response= client.search(searchRequest, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        // 关闭客户端连接
        client.close();
    }
}
