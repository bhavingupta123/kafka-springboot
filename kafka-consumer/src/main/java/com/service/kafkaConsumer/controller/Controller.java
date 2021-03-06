package com.service.kafkaConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate ;

    private static final String topic="topic2";

    @GetMapping("/publish2/{msg}")
    public String publicMsg(@PathVariable("msg") String msg){
        this.kafkaTemplate.send(topic,msg);
        return "published2";
    }

}
