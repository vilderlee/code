package com.vilderlee.http;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

/**
 * 功能描述:
 *
 * @package com.vilderlee.http
 * @auther vilderlee
 * @date 2020/2/24 10:25 上午
 */
public class HttpUtils {

    private static HttpClient httpClient;

    public static HttpClient getHttpClient() {
        return httpClient = HttpClientBuilder.create().build();
    }

    public static void connect(String url, String json) throws Exception {
        HttpPost post = new HttpPost(url);
        if (!StringUtils.isEmpty(json)) {
            post.setEntity(new ByteArrayEntity(json.getBytes()));
        }
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        post.setHeader("Content-Encoding", "utf-8");

        HttpResponse response = httpClient.execute(post);
        System.out.println(httpClient);
        System.out.println("响应状态：" + response.getStatusLine());

        HttpEntity entity = response.getEntity();

        String string = EntityUtils.toString(entity, "utf-8");
        System.out.println("响应内容为:" + string);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(string);
        JSONObject data = (JSONObject) JSONObject.parse((String) jsonObject.get("data"));

        System.out.println();

//        JSON json1 = JSON.parseObject(inputStream, String.class,)
    }

    public static String getSessionID() throws Exception {
        HttpPost post = new HttpPost("http://172.31.2.15/zentao/api-getSessionID.json");

        HttpResponse response = httpClient.execute(post);
        System.out.println(httpClient);
        System.out.println("响应状态：" + response.getStatusLine());

        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity, "utf-8");
        System.out.println("响应内容为:" + string);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(string);
        JSONObject data = (JSONObject) JSONObject.parse((String) jsonObject.get("data"));


//        BasicCookieStore cookieStore = new BasicCookieStore();
//        BasicClientCookie cookie = new BasicClientCookie("zentaosid", (String) data.get("sessionID"));
//        cookieStore.addCookie(cookie);
//        httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

        HttpPost post2 = new HttpPost("http://172.31.2.15/zentao/user-login.json");
        String json = JSON.toJSONString(new Account("CMDB", "CPCN1234!@#"));
        post.setEntity(new ByteArrayEntity(json.getBytes()));
        HttpResponse response2 = httpClient.execute(post2);
        System.out.println(httpClient);
        System.out.println("响应状态2：" + response2.getStatusLine());

        HttpEntity entity2 = response2.getEntity();
        String string2 = EntityUtils.toString(entity2, "utf-8");
        System.out.println("响应内容2为:" + string2);
        JSONObject jsonObject2 = (JSONObject) JSONObject.parse(string2);
        JSONObject data2 = (JSONObject) JSONObject.parse((String) jsonObject2.get("data"));


        return (String) data.get("sessionID");
    }

    public static void main(String[] args) throws Exception {
        HttpUtils.getHttpClient();
        String sessionID = HttpUtils.getSessionID();
        String json = JSON.toJSONString(new Account("CMDB", "CPCN1234!@#"));
        HttpUtils.connect("http://172.31.2.15/zentao/user-login.json?zentaosid=" + sessionID +"&t=json", json);
//        HttpUtils.connect("http://172.31.2.15/zentao/product-all-51--noclosed-order_desc-200-200-1.json", "");

    }


    @Data
    @AllArgsConstructor
    static class Account {
        private String account;
        private String password;
    }
}
