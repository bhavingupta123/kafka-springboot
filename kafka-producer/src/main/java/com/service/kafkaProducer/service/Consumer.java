package com.service.kafkaProducer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "topic2",groupId = "group2")
    public void consumeTopic(String msg){
        System.out.println("consumed2:" + msg);
    }

}
