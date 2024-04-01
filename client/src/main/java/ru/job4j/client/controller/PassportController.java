package ru.job4j.client.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.client.model.Passport;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "passport-controller", description = "Passport manipulation API")
public class PassportController {

    @Value("${config.server-passport-url}")
    private String serverUrl;

    @Autowired
    private RestTemplate rest;

    @GetMapping("/find")
    public List<Passport> findAll() {
        List<Passport> passports = rest.exchange(
                serverUrl + "/find",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @GetMapping("/find-by-series")
    public List<Passport> findBySeries(@RequestParam Integer series) {
        List<Passport> passports = rest.exchange(
                serverUrl + "find-by-series" + "?series=" + series,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @GetMapping("/find-expired")
    public List<Passport> findExpired() {
        List<Passport> passports = rest.exchange(
                serverUrl + "/find-expired",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findReplaceable() {
        List<Passport> passports = rest.exchange(
                serverUrl + "/find-replaceable",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() { }
        ).getBody();
        return passports;
    }

    @PostMapping("/save")
    public Passport save(@RequestBody Passport passport) {
        return rest.postForObject(serverUrl + "/save", passport, Passport.class);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Passport passport) {
        rest.put(serverUrl + "/update", passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        rest.delete(serverUrl + "/delete" + "?id=" + id);
        return ResponseEntity.ok().build();
    }
}
