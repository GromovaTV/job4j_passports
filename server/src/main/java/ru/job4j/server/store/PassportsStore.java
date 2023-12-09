package ru.job4j.server.store;

import org.springframework.data.jpa.repository.Query;
import ru.job4j.server.model.Passport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassportsStore extends CrudRepository<Passport, Long> {
    List<Passport> findBySeries(int series);

    @Query("SELECT p FROM Passport p WHERE p.expiration < CURRENT_DATE")
    List<Passport> findExpired();

    @Query(value = "SELECT * FROM passports p WHERE p.expiration > CURRENT_DATE AND p.expiration < CURRENT_DATE + INTERVAL '3 MONTH'", nativeQuery = true)
    List<Passport> findReplaceable();
}
