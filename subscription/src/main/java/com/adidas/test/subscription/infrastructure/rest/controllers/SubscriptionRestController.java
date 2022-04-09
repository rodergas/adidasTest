package com.adidas.test.subscription.infrastructure.rest.controllers;

import com.adidas.test.subscription.application.SubscriptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/subscriptions"})
public class SubscriptionRestController {
    private final SubscriptionService subscriptionService;

    public SubscriptionRestController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public void createNewSubscription() {
        this.subscriptionService.createSubscription();
    }

    @DeleteMapping({"/{id}"})
    public String cancelSubscriptionById(@PathVariable String id) {
        return "ID: ";
    }

    @GetMapping({"/{id}"})
    public String getSubscriptionById(@PathVariable String id) {
        return "ID: " + id;
    }

    @GetMapping
    public String getAllSubscriptions() {
        return "All subscriptions ";
    }
}