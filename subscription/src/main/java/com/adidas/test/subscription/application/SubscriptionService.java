package com.adidas.test.subscription.application;

import com.adidas.test.subscription.domain.Subscription;
import com.adidas.test.subscription.infrastructure.repositories.SubsriptionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriptionService {
    @Value("${topic.name}")
    private String topicName;
    private final KafkaTemplate<String, Subscription> kafkaTemplate;
    private final SubsriptionRepository subsriptionRepository;

    public SubscriptionService(KafkaTemplate<String, Subscription> kafkaTemplate, SubsriptionRepository subsriptionRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.subsriptionRepository = subsriptionRepository;
    }

    public Subscription createSubscription(Subscription subscription) {
        subsriptionRepository.save(subscription);
        kafkaTemplate.send(this.topicName, subscription);
        return subscription;
    }
}