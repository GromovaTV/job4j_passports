package ru.job4j.passports.controller;

import ru.job4j.passports.model.Passport;
import org.springframework.web.bind.annotation.*;
import ru.job4j.passports.service.PassportsService;
import java.util.List;

@RestController
@RequestMapping("/")
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
