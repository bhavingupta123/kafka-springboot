package com.service.kafkaProducer.service;

import com.service.kafkaProducer.model.Connector;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    Connector connector;

    @KafkaListener(topics = "topic2",groupId = "group2") // listen to events on topic2
    public void consumeTopic(String msg){
        connector = new Connector();
        connector.storeData(msg); // store data to DB
        System.out.println("consumed2:" + msg);
    }

}
