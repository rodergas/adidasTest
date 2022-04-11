package com.adidas.test.subscription.application;

import com.adidas.test.subscription.domain.Subscription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriptionService {
    @Value("${topic.name}")
    private String topicName;
    private final KafkaTemplate<String, Subscription> kafkaTemplate;

    public SubscriptionService(KafkaTemplate<String, Subscription> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Subscription createSubscription() {
        Subscription subscription = Subscription.builder().email("robert@test.com").birthDate(new Date()).campaignId("ASASS").gender("man").build();
        kafkaTemplate.send(this.topicName, subscription);
        return subscription;
    }
}