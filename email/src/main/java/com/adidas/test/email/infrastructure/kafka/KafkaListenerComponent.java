package com.adidas.test.email.infrastructure.kafka;
import com.adidas.test.email.application.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

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

    public void listen(String in) throws JsonProcessingException {
        emailService.sendEmail(in);
    }
}
