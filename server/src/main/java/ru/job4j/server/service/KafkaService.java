package ru.job4j.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.job4j.server.model.Passport;
import ru.job4j.server.store.PassportsStore;

import java.util.List;

@Component
public class KafkaService {
    private final PassportsStore store;

    @Autowired
    private KafkaTemplate<String, String> template;

    public KafkaService(PassportsStore store) {
        this.store = store;
    }

    @Scheduled(fixedDelay = 60_000)
    public void sendOrder(){
        System.out.println("start sendOrder");
        List<Passport> passports = store.findExpired();
        System.out.println("passport size: " + passports.size());
        if (!passports.isEmpty()) {
            System.out.println("Try to send a mail");
            for (Passport p : passports) {
                template.send("expired", p.getSeries() + " " + p.getNumber());
            }
        }
    }
}
