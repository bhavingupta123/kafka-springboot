package com.service.kafkaProducer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate ;

    private static final String topic="topic1";

    @GetMapping("/publish/{msg}")
    public String publicMsg(@PathVariable("msg") String msg){
        this.kafkaTemplate.send(topic,msg);
        return "published";
    }

}
