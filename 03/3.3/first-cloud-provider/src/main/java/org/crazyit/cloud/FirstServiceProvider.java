package org.crazyit.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstServiceProvider {
    public static void main(String[] args){
        try (Scanner scan = new Scanner(System.in)) {
            String port = scan.nextLine();
            new SpringApplicationBuilder(FirstServiceProvider.class)
                .properties("server.port=" + port).run(args);
        }
        
    }
}
