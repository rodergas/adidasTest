package com.adidas.test.publicservice.infrastructure;

import com.adidas.test.publicservice.application.PublicService;
import com.adidas.test.publicservice.domain.Subscription;
import com.adidas.test.publicservice.domain.SubscriptionCreateDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.net.URI;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class PublicController {

    private final PublicService publicService;

    public PublicController(PublicService publicService){
        this.publicService = publicService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionCreateDTO> createNewSubscription(@Valid @RequestBody Subscription subscription) {
        SubscriptionCreateDTO subscriptionSaved = publicService.createSubscription(subscription);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(subscriptionSaved.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(subscriptionSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelSubscriptionById(@PathVariable Long id) {
        return publicService.cancelSubscription(id)
                .map(subs -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        return publicService.getSubscriptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Subscription>> getAllSubscriptions() {
        return ResponseEntity.ok(publicService.getAllSubscriptions());
    }

}
