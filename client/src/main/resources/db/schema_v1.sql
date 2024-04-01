create table IF NOT EXISTS client.u_role (
    id serial primary key not null,
    role varchar(2000)
);

create table IF NOT EXISTS client.person (
    id serial primary key not null,
    login varchar(2000) unique,
    password varchar(2000)
);

create table IF NOT EXISTS client.persons_roles (
    id serial primary key not null,
    person_id int not null references person(id),
    role_id int not null references u_role(id)
);

insert into client.u_role (role) values ('ROLE_ADMIN');
insert into client.u_role (role) values ('ROLE_ANONYMOUS');
insert into client.u_role (role) values ('ROLE_USER');
insert into client.person (login, password) values ('rootrt', '$2a$10$WgQczFNvCmkwOD4fU/nJc.kthzSnnl16vACRdhvM.ud8FTZL5zPm.'); -- password: 123456
insert into client.person (login, password) values ('Thomas', '$2a$10$WgQczFNvCmkwOD4fU/nJc.kthzSnnl16vACRdhvM.ud8FTZL5zPm.');
insert into client.persons_roles (person_id, role_id) values (1, 1);
insert into client.persons_roles (person_id, role_id) values (2, 3);