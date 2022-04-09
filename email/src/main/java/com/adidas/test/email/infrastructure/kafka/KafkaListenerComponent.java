package com.adidas.test.email.infrastructure.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerComponent {

    @KafkaListener(
            id = "myId",
            topics = {"t.newsletter.createSubscription"}
    )

    public void listen(String in) {
        System.out.println(in);
    }
}
