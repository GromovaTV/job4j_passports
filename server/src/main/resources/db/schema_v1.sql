create table IF NOT EXISTS passports (
    id serial primary key not null,
    series integer not null,
    number integer not null,
    name varchar(2000) not null,
    surname varchar(2000) not null,
    expiration DATE,
    CONSTRAINT unique_series_number UNIQUE (series, number)
);

INSERT INTO passports (series, number, name, surname, expiration)
VALUES (1234, 1234, 'John', 'Doe', '2023-12-31');

INSERT INTO passports (series, number, name, surname, expiration)
VALUES (1234, 2345, 'John', 'Doe', '2023-12-05');

INSERT INTO passports (series, number, name, surname, expiration)
VALUES (2345, 1234, 'John', 'Doe', '2024-12-31');