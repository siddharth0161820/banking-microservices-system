package com.Account.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    //Create a Bean
    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("account-statement-topic")//name of the topic that is to be created
                .partitions(1)//we can skip if dont wana add explicitly
                .replicas(1)//Replica means a copy of a Kafka partition stored on another broker.
                .build(); //
    }

}
