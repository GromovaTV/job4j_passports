package ru.job4j.client.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class Passport {

    private Long id;
    private Integer series;
    private Integer number;
    private String name;
    private String surname;
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
