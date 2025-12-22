package com.Statement.StatementService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StatementConsumerService {

   // @KafkaListener(topics = "account-statement-topic", groupId = "account-statement-consumer")
    @KafkaListener(topics = "account-statement-topic")
    public void consume(String message) {
        System.out.println("Message received/consumed from Kafka topic: " + message);
    }
}
