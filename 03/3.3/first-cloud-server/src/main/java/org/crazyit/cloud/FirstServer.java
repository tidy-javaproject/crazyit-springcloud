package org.crazyit.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FirstServer 
{
    public static void main( String[] args )
    {
        
        try (Scanner scan = new Scanner(System.in)) {
            String profiles = scan.nextLine();
            new SpringApplicationBuilder(FirstServer.class)
                .profiles(profiles).run(args);
        }
        

    }
}
