package com.adidas.test.publicservice.infrastructure;

import com.adidas.test.publicservice.application.PublicService;
import com.adidas.test.publicservice.domain.Subscription;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class PublicController {

    private final PublicService publicService;

    public PublicController(PublicService publicService){
        this.publicService = publicService;
    }

    @PostMapping
    public Subscription createNewSubscription(@RequestBody Subscription subscription) {
        return publicService.createSubscription(subscription);
    }

    @DeleteMapping("/{id}")
    public String cancelSubscriptionById(@PathVariable Long id) {
        return publicService.cancelSubscription(id);
    }

    @GetMapping("/{id}")
    public Optional<Subscription> getSubscriptionById(@PathVariable Long id) {
        return publicService.getSubscriptionById(id);
    }

    @GetMapping
    public Iterable<Subscription> getAllSubscriptions() {
        return publicService.getAllSubscriptions();
    }
}
