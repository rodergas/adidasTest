package com.adidas.test.publicservice.application;

import com.adidas.test.publicservice.domain.Subscription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PublicService {

    private final RestTemplate restTemplate;
    private final String subscriptionServiceURL;
    public PublicService(RestTemplate restTemplate, @Value("${subscriptionServiceURL}") String subscriptionServiceURL){
        this.restTemplate = restTemplate;
        this.subscriptionServiceURL = subscriptionServiceURL;
    }

    public Subscription createSubscription(Subscription subscription){

        ResponseEntity<Subscription> response = restTemplate
                .exchange(subscriptionServiceURL + "/subscriptions", HttpMethod.POST, new HttpEntity<>(subscription), Subscription.class);
        return response.getBody();
    }
}
