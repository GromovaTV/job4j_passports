package ru.job4j.client.model;

import java.sql.Date;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id)
                && Objects.equals(series, passport.series)
                && Objects.equals(number, passport.number)
                && Objects.equals(name, passport.name)
                && Objects.equals(surname, passport.surname)
                && Objects.equals(expiration, passport.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, number, name, surname, expiration);
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
