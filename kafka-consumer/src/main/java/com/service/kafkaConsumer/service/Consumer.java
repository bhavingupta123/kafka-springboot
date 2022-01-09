package com.service.kafkaConsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "topic1",groupId = "group1")
    public void consumeTopic(String msg){

        System.out.println("consumed:" + msg);
    }
}
