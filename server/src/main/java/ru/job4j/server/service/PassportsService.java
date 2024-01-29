package ru.job4j.server.service;

import org.springframework.stereotype.Service;
import ru.job4j.server.model.Passport;
import ru.job4j.server.store.PassportsStore;

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

    public List<Passport> find() {
        return (List<Passport>) store.findAll();
    }

    public List<Passport> findBySeries(int series) {
        return  store.findBySeries(series);
    }

    public List<Passport> findExpired() {
        return  store.findExpired();
    }

    public List<Passport> findReplaceable() {
        return  store.findReplaceable();
    }

    public void update(Passport passport) {
        Passport res = store.findById(passport.getId()).orElseThrow();
        res.setNumber(passport.getNumber());
        res.setSeries(passport.getSeries());
        res.setName(passport.getName());
        res.setSurname(passport.getSurname());
        res.setExpiration(passport.getExpiration());
        store.save(res);
    }

    public void delete(long id) {
        Passport passport = new Passport();
        passport.setId(id);
        store.delete(passport);
    }
}
