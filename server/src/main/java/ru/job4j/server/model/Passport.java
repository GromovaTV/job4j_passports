package ru.job4j.server.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "passports")
@Data
@RequiredArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series", unique = true, nullable = false)
    private Integer series;

    @Column(name = "number", unique = true, nullable = false)
    private Integer number;

    @Column(name = "name", nullable = false, length = 2000)
    private String name;

    @Column(name = "surname", nullable = false, length = 2000)
    private String surname;

    @Column(name = "expiration")
    private Date expiration;

    public static Passport of(int series, int number, String name,
                              String surname, Date expiration) {
        Passport passport = new Passport();
        passport.name = name;
        passport.surname = surname;
        passport.series = series;
        passport.number = number;
        passport.expiration = expiration;
        return passport;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "id=" + id
                + ", series=" + series
                + ", number=" + number
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", expiration=" + expiration
                + '}';
    }
}
