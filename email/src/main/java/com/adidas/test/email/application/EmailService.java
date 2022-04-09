package com.adidas.test.email.application;

import com.adidas.test.email.domain.CreateSubscriptionEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String in) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateSubscriptionEvent createSubscriptionEvent = objectMapper.readValue(in, CreateSubscriptionEvent.class);
        System.out.println("llego");
    }
}
