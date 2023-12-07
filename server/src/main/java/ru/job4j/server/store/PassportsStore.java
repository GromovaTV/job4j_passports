package ru.job4j.server.store;

import ru.job4j.server.model.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportsStore extends CrudRepository<Passport, Long> {
}
