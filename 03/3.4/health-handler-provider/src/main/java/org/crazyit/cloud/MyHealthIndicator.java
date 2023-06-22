package org.crazyit.cloud;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if(HealthController.canVisitDb){
            // 成功连接数据库， 返回UP
            return new Health.Builder(Status.UP).build();
        }else{
            // 连接数据库失败， 返回 out of service
            return new Health.Builder(Status.DOWN).build();
        }
    }
    
}
