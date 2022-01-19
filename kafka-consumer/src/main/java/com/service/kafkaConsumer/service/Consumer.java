package com.service.kafkaConsumer.service;

import com.service.kafkaConsumer.model.Connector;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    Connector connector;

    @KafkaListener(topics = "topic2",groupId = "group2")
    public void consumeTopic(String msg){
        System.out.println("f 12");
        connector = new Connector();
        connector.storeData(msg);
        System.out.println("consumed:" + msg);
    }
}
