package ru.job4j.server.controller;

import ru.job4j.server.model.Passport;
import ru.job4j.server.service.PassportsService;
import org.springframework.web.bind.annotation.*;

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
    public List<Passport> getAll() {
        return (List<Passport>) service.getAll();
    }
}
