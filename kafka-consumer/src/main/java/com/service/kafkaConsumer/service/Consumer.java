package com.service.kafkaConsumer.service;

import com.service.kafkaConsumer.controller.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    Connector connector;

    @KafkaListener(topics = "topic1",groupId = "group1")
    public void consumeTopic(String msg){
        connector = new Connector();
        connector.storeData(msg);
        System.out.println("consumed:" + msg);
    }
}
