package com.lkl.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("hello")
    @ResponseBody
    public String testHello(String name){
        List<String> serverNames = discoveryClient.getServices();
        if(serverNames != null && serverNames.size() > 0){
            for (String serverName : serverNames){
                List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
                System.out.println("serviceName:"+serverName);
                if(serviceInstances != null && serviceInstances.size() > 0){
                    for (ServiceInstance instance : serviceInstances){
                        String host = instance.getHost();
                        int port = instance.getPort();
                        Map<String, String> metaData = instance.getMetadata();
                        URI uri = instance.getUri();
                        System.out.println("host:"+host+"  port:"+port+"  uri:"+uri.toString());
                        Iterator<String> iterator = metaData.keySet().iterator();
                        while(iterator.hasNext()){
                            String key = iterator.next();
                            System.out.println("key:"+key+" value:"+metaData.get(key));
                        }
                    }
                }
            }
        }
        return "hello,"+name;
    }
}
