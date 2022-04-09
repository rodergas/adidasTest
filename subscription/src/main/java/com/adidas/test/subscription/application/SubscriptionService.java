package com.adidas.test.subscription.application;

import com.adidas.test.subscription.domain.CreateSubscriptionEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriptionService {
    @Value("${topic.name}")
    private String topicName;
    private final KafkaTemplate kafkaTemplate;

    public SubscriptionService(KafkaTemplate<String, CreateSubscriptionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createSubscription() {
        kafkaTemplate.send(this.topicName, CreateSubscriptionEvent.builder().email("robert@test.com").birthDate(new Date()).campaignId("ASASS").gender("man").build());
    }
}