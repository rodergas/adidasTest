package com.adidas.test.subscription.infrastructure.controllers;

import com.adidas.test.subscription.application.SubscriptionService;
import com.adidas.test.subscription.domain.Subscription;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionRestController {
    private final SubscriptionService subscriptionService;

    public SubscriptionRestController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription createNewSubscription(@Valid @RequestBody Subscription subscription) {
        return this.subscriptionService.createSubscription(subscription);
    }

    @DeleteMapping("/{id}")
    public Optional<Subscription> cancelSubscriptionById(@PathVariable Long id) {
        return subscriptionService.deleteSubscription(id);
    }

    @GetMapping("/{id}")
    public Optional<Subscription> getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @GetMapping
    public Iterable<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
}