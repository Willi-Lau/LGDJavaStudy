package com.lwy.es.com.lwy.demo.crudData;

import org.apache.http.HttpHost;
import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;
import java.io.IOException;

/**
 * @Author liuweiyi
 * 全量查询
 * 条件查询
 * 分页查询
 * 指定字段排序查询
 * 过滤指定字段查询 指定包含哪些字段 不好喊哪些字段
 * 组合查询 设置must should 条件
 * 指定字段范围查询
 */
public class EsGetDataQuery {
    public static void main(String[] args) throws IOException {
         //创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        /**
         * 全部查询
         */
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
        System.out.println("******************************");
        /**
         * 条件查询
         *
         */
        // 创建索引 - 请求对象
        SearchRequest searchRequest1 = new SearchRequest();
        //设置索引名字
        searchRequest1.indices("happy");
        //设置查询条件
        SearchRequest sources1 = searchRequest1.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",19)));
        //执行
        SearchResponse response1 = client.search(searchRequest1, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response1.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        System.out.println("******************************");
        /**
         * 分页查询
         *
         */
        // 创建索引 - 请求对象
        SearchRequest searchRequest2 = new SearchRequest();
        //设置索引名字
        searchRequest2.indices("happy");
        //设置查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //起始位置
        builder.from(0);
        //每一页几条数据
        builder.size(2);
        SearchRequest sources2 = searchRequest2.source(builder);
        //执行
        SearchResponse response2 = client.search(searchRequest2, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response2.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        System.out.println("******************************");
        /**
         * 指定字段排序查询
         *
         */
        // 创建索引 - 请求对象
        SearchRequest searchRequest3 = new SearchRequest();
        //设置索引名字
        searchRequest3.indices("happy");
        //设置查询条件
        SearchSourceBuilder builder2 = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //排序字段 age 升序
        builder2.sort("age", SortOrder.ASC);
        SearchRequest sources3 = searchRequest3.source(builder2);
        //执行
        SearchResponse response3 = client.search(searchRequest3, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response3.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        System.out.println("******************************");
        /**
         * 过滤指定字段查询 指定包含哪些字段 不好喊哪些字段
         *
         */
        // 创建索引 - 请求对象
        SearchRequest searchRequest4 = new SearchRequest();
        //设置索引名字
        searchRequest4.indices("happy");
        //设置查询条件
        SearchSourceBuilder builder3 = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //包含哪些字段
        String[] include = {"name"};
        //不包含哪些字段
        String[] exclude = {"age"};
        builder3.fetchSource(include,exclude);
        SearchRequest sources4 = searchRequest4.source(builder3);
        //执行
        SearchResponse response4 = client.search(searchRequest4, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response4.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        System.out.println("******************************");
        /**
         * 组合查询 设置must should 条件
         *
         */
        // 创建索引 - 请求对象
        SearchRequest searchRequest5 = new SearchRequest();
        //设置索引名字
        searchRequest5.indices("happy");
        //设置查询条件
        SearchSourceBuilder builder4 =  new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //设置必须存在的条件 年龄必须是11  sex必须是女
        boolQueryBuilder.must(QueryBuilders.matchQuery("age",11));
        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","女"));
        //名字是张三李四之一就可以
        boolQueryBuilder.should(QueryBuilders.matchQuery("name","张三"));
        boolQueryBuilder.should(QueryBuilders.matchQuery("name","李四"));

        builder4.query(boolQueryBuilder);
        SearchRequest sources5 = searchRequest5.source(builder4);
        //执行
        SearchResponse response5 = client.search(searchRequest5, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response5.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        System.out.println("******************************");
        /**
         * 组合查询 设置must should 条件
         *
         */
        // 创建索引 - 请求对象
        SearchRequest searchRequest6 = new SearchRequest();
        //设置索引名字
        searchRequest6.indices("happy");
        //设置查询条件
        SearchSourceBuilder builder5 =  new SearchSourceBuilder();
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
        //设置范围 >= 30  <50
        rangeQueryBuilder.gte(30);
        rangeQueryBuilder.lt(50);

        builder5.query(rangeQueryBuilder);
         searchRequest6.source(builder5);
        //执行
        SearchResponse response6 = client.search(searchRequest6, RequestOptions.DEFAULT);

        //结果 遍历所有的内容 json形式
        response6.getHits().forEach((searchHit)->{
            System.out.println(searchHit.getSourceAsString());
        });
        System.out.println("******************************");










        // 关闭客户端连接
        client.close();
    }
}
