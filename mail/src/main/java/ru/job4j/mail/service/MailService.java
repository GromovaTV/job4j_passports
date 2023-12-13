package ru.job4j.mail.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @KafkaListener(topics="expired")
    public void msgListener(String msg){
        System.out.println(msg);
    }
}
