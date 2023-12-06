package ru.job4j.passports.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "passports")
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

    @Column(name = "expired")
    private Date expired;

    public static Passport of(int series, int number, String name, String surname, Date expired) {
        Passport passport = new Passport();
        passport.name = name;
        passport.surname = surname;
        passport.series = series;
        passport.number = number;
        passport.expired = expired;
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

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id) &&
                Objects.equals(series, passport.series) &&
                Objects.equals(number, passport.number) &&
                Objects.equals(name, passport.name) &&
                Objects.equals(surname, passport.surname) &&
                Objects.equals(expired, passport.expired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, number, name, surname, expired);
    }

    @Override
    public String toString() {
        return "Passport{"
                + "id=" + id
                + ", series=" + series
                + ", number=" + number
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", expired=" + expired
                + '}';
    }
}
