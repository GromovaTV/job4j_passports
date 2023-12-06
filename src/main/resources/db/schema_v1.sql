create table IF NOT EXISTS passports (
    id serial primary key not null,
    series integer not null unique,
    number integer not null unique,
    name varchar(2000) not null,
    surname varchar(2000) not null,
    expired DATE
);

INSERT INTO passports (series, number, name, surname, expired)
VALUES (1234, 1234, 'John', 'Doe', '2024-12-31');