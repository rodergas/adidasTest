package com.adidas.test.email.infrastructure.kafka;
import com.adidas.test.email.application.EmailService;
import com.adidas.test.email.domain.Subscription;
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
            id = "myId",
            topics = {"t.newsletter.createSubscription"}
    )

    public void listen(@Valid Subscription in) {
        emailService.sendEmail(in);
    }
}
