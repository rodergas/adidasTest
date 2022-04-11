package com.adidas.test.publicservice.application;

import com.adidas.test.publicservice.domain.Subscription;
import com.adidas.test.publicservice.domain.SubscriptionCreateDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PublicService {

    private final RestTemplate restTemplate;
    private final String subscriptionServiceURL;
    public PublicService(RestTemplate restTemplate, @Value("${subscriptionServiceURL}") String subscriptionServiceURL){
        this.restTemplate = restTemplate;
        this.subscriptionServiceURL = subscriptionServiceURL;
    }

    public SubscriptionCreateDTO createSubscription(Subscription subscription){

        ResponseEntity<SubscriptionCreateDTO> response = restTemplate
                .exchange(subscriptionServiceURL + "/subscriptions", HttpMethod.POST, new HttpEntity<>(subscription), SubscriptionCreateDTO.class);
        return response.getBody();
    }

    public Iterable<Subscription> getAllSubscriptions(){

        ResponseEntity<Iterable<Subscription>> response = restTemplate
                .exchange(subscriptionServiceURL + "/subscriptions", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Subscription>>() {});
        return response.getBody();
    }

    public Optional<Subscription> getSubscriptionById(Long id){

        ResponseEntity<Optional<Subscription>> response = restTemplate
                .exchange(subscriptionServiceURL + String.format("/subscriptions/%s",id), HttpMethod.GET, null, new ParameterizedTypeReference<Optional<Subscription>>() {});
        return response.getBody();
    }

    public Optional<Subscription> cancelSubscription(Long id){

        ResponseEntity<Optional<Subscription>> response = restTemplate
                .exchange(subscriptionServiceURL + String.format("/subscriptions/%s",id), HttpMethod.DELETE, null,  new ParameterizedTypeReference<Optional<Subscription>>() {});
        return response.getBody();
    }
}
