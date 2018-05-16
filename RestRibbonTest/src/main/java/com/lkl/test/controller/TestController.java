package com.lkl.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestController {

    @Autowired
    RestTemplate restTemplate;
    @Value("${lkl.name}")
    private String k;
    @RequestMapping("restTest")
    @ResponseBody
    public String restRibbonTest(String name){
//        String k = restTemplate.getForObject("http://lkl/hello?name="+name,String.class);
        return k;
    }
}
