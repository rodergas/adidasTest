package com.adidas.test.publicservice.infrastructure;

import com.adidas.test.publicservice.application.PublicService;
import com.adidas.test.publicservice.domain.Subscription;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class PublicController {

    private final PublicService publicService;

    public PublicController(PublicService publicService){
        this.publicService = publicService;
    }

    @PostMapping
    public Subscription createNewSubscription(@RequestBody Subscription subscription) {
        return this.publicService.createSubscription(subscription);
    }

    @DeleteMapping("/{id}")
    public String cancelSubscriptionById(@PathVariable String id) {
        return "ID: ";
    }

    @GetMapping("/{id}")
    public String getSubscriptionById(@PathVariable String id) {
        return "ID: " + id;
    }

    @GetMapping
    public String getAllSubscriptions() {
        return "All subscriptions ";
    }
}
