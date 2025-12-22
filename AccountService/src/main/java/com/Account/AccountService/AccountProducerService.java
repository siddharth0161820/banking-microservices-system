package com.Account.AccountService;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public AccountProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private static final String TOPIC = "account-statement-topic";

    // Method to send/publish messages
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message sent to topic " + TOPIC + ": " + message);//Lets you see in your Spring Boot console that the message was sent
    }
}
