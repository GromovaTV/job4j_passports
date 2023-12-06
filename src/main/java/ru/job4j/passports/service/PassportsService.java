package ru.job4j.passports.service;

import org.springframework.stereotype.Service;
import ru.job4j.passports.model.Passport;
import ru.job4j.passports.store.PassportsStore;
import java.util.List;

@Service
public class PassportsService {
    private final PassportsStore store;

    public PassportsService(PassportsStore store) {
        this.store = store;
    }

    public Passport save(Passport passport) {
        return store.save(passport);
    }

    public List<Passport> getAll() {
        return (List<Passport>) store.findAll();
    }
}
