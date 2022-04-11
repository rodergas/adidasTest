package com.adidas.test.subscription.application;

import com.adidas.test.subscription.domain.Subscription;
import com.adidas.test.subscription.infrastructure.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {
    @Value("${topic.name}")
    private String topicName;
    private final KafkaTemplate<String, Subscription> kafkaTemplate;
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(KafkaTemplate<String, Subscription> kafkaTemplate, SubscriptionRepository subscriptionRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
        kafkaTemplate.send(this.topicName, subscription);
        return subscription;
    }

    public Optional<Subscription> deleteSubscription(Long id){
        Optional<Subscription> subscription = getSubscription(id);
        subscription.ifPresent(subs -> subscriptionRepository.deleteById(id));
        return subscription;
    }

    public Optional<Subscription> getSubscription(Long id){
        return subscriptionRepository.findById(id);
    }

    public Iterable<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }
}