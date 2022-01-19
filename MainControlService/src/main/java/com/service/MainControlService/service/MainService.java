package com.service.MainControlService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/start")
public class MainService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/publish1/{msg}")   // for service1
    public String publish1(@PathVariable("msg") String msg){

        System.out.println("here1");
        String res1 = restTemplate.getForObject("http://localhost:8081/publish/" + msg,String.class); // call microservice 1
        return res1;
    }

    @RequestMapping("/publish2/{msg}") // for service 2
    public String publish2(@PathVariable("msg") String msg){

        System.out.println("here2");
        String res2 = restTemplate.getForObject("http://localhost:8082/publish2/" + msg,String.class); // call microservice 2
        return res2;
    }
}
