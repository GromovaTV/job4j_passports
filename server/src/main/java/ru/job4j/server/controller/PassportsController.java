package ru.job4j.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.server.model.Passport;
import ru.job4j.server.service.PassportsService;

import java.util.List;

@RestController
@RequestMapping("")
public class PassportsController {

    private final PassportsService service;

    public PassportsController(PassportsService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Passport save(@RequestBody Passport passport) {
        return service.save(passport);
    }

    @GetMapping("/find")
    public List<Passport> find() {
        return service.find();
    }

    @GetMapping("/find-by-series")
    public List<Passport> findBySeries(@RequestParam Integer series) {
        return service.findBySeries(series);
    }

    @GetMapping("/find-expired")
    public List<Passport> findExpired() {
        return service.findExpired();
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findReplaceable() {
        return service.findReplaceable();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Passport passport) {
        service.update(passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
