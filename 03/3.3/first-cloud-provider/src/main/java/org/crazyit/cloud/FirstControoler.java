package org.crazyit.cloud;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstControoler 
{
    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person main(@PathVariable("personId") Integer personId, HttpServletRequest request)
    {
        Person person = new Person(personId, "Crazit", 30);
        //为了查看结果 ， 将请求的 URL 设置到 Person 实例中
        person.setMessage(request.getRequestURL().toString());
        return person;

    }
}
