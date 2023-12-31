package org.crazyit.cloud;

import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;

public class TestRestClient 
{
 

    public static void main( String[] args ) throws Exception
    {
        // 设置请求的服务器
        ConfigurationManager.getConfigInstance().setProperty(
            "my-client.ribbon.listOfServers",
            "localhost:8080,localhost:8081"
        );

        // 获取REST请求客户端
        RestClient client = (RestClient)ClientFactory.getNamedClient("my-client");
        
        // 创建请求示例
        HttpRequest request = HttpRequest
            .newBuilder()
            .uri("/person/1").build();
        
        // 发送6次请求到服务器中
        for(int i = 0; i < 6; i++){
            HttpResponse response = client.executeWithLoadBalancer(request);
            String result = response.getEntity(String.class);
            System.out.println(result);
        }
            
    }
}
