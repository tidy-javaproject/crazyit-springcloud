package org.crazyit.cloud;


import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestHttpCIient {
    public static void main(String[] args) {
        // 创建默认的HttpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 调用6次服务并输出结果
        for(int i = 0; i < 600; i++){
            // 调用 GET 方法请求服务
            HttpGet httpget = new HttpGet("http://localhost:9000/router");
            // 获取响应
            HttpResponse response;
            try {
                response = httpclient.execute(httpget);
                // 根据相应解析出字符串
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        }

    }
}
