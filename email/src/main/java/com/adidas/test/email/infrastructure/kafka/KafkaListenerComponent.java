package com.adidas.test.email.infrastructure.kafka;
import com.adidas.test.email.application.EmailService;
import com.adidas.test.email.domain.Subscription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class KafkaListenerComponent {
    private final EmailService emailService;

    public KafkaListenerComponent(EmailService emailService){
        this.emailService = emailService;
    }

    @KafkaListener(
            id = "subscriptionListener",
            topics = "#{'${kafka.topics.subscription}'.split(',')}"
    )

    public void listen(@Valid Subscription in) {
        emailService.sendEmail(in);
    }
}
