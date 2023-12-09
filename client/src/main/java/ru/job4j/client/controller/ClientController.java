package ru.job4j.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.client.model.Passport;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private RestTemplate rest;

    private static final String API = "http://localhost:8080/find";
    private static final String API_SERIES = "http://localhost:8080/find-by-series";
    private static final String API_UNVB = "http://localhost:8080/unavailable";
    private static final String API_RPL = "http://localhost:8080/find-replaceable";
    private static final String API_SAVE = "http://localhost:8080/save";
    private static final String API_UPD= "http://localhost:8080/update";
    private static final String API_DEL = "http://localhost:8080/delete";

    @GetMapping("/find")
    public List<Passport> findAll() {
        List<Passport> passports = rest.exchange(
                API,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @GetMapping("/find-by-series")
    public List<Passport> findBySeries(@RequestParam Integer series) {
        List<Passport> passports = rest.exchange(
                API_SERIES + "?series=" + series,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @GetMapping("/unavailable")
    public List<Passport> findExpired() {
        List<Passport> passports = rest.exchange(
                API_UNVB,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findReplaceable() {
        List<Passport> passports = rest.exchange(
                API_RPL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @PostMapping("/save")
    public Passport save(@RequestBody Passport passport) {
        return rest.postForObject(API_SAVE, passport, Passport.class);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Passport passport) {
        rest.put(API_UPD, passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        rest.delete(API_DEL + "?id=" + id);
        return ResponseEntity.ok().build();
    }
}
