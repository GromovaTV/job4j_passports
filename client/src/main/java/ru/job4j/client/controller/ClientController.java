package ru.job4j.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.job4j.client.model.Passport;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private RestTemplate rest;

    private static final String API = "http://localhost:8080/find";

    @GetMapping("/find")
    public List<Passport> findAll() {
        List<Passport> passports = rest.exchange(
                API,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }
}
