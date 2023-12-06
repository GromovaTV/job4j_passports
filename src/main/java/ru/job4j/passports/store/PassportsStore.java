package ru.job4j.passports.store;

import ru.job4j.passports.model.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportsStore extends CrudRepository<Passport, Long> {
}
