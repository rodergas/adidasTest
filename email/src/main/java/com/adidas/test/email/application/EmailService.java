package com.adidas.test.email.application;

import com.adidas.test.email.domain.Subscription;
import com.adidas.test.email.exceptions.EmailException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendEmail(Subscription subscription) {

        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);//instantiates a multipart message

            mimeMessageHelper.setTo(subscription.getEmail());
            mimeMessageHelper.setFrom("robertalmar@gmail.com");
            mimeMessageHelper.setSubject("Adidas test");
            mimeMessageHelper.setText("Sending fake email...");
            mailSender.send(message);
        }catch(MessagingException messagingException){
            throw new EmailException(messagingException.getMessage());
        }
    }
}
