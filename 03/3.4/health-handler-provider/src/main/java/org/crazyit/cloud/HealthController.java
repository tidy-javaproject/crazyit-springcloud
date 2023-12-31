package org.crazyit.cloud;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    // 标识当前数据库是否可以访问
    static Boolean canVisitDb = false;

    @RequestMapping(value = "/db/{canVisitDb}", method = RequestMethod.GET)
    @ResponseBody
    public String setConnectState(@PathVariable("canVisitDb") Boolean canVisitDB){
        HealthController.canVisitDb = canVisitDB;
        return "当前数据库是否正常: " + HealthController.canVisitDb;
    }

    
}
