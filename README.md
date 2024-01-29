# Passports

Сервис для управления паспортами.

## Dependencies

* Kafka
* Spring Boot Data JPA
* Spring Boot 2
* Java
* Hibernate, PostgreSQL
* Liquibase
* Maven
* Checkstyle

## REST API:

GET: /api/find/

GET: /api/find/{id}

GET: /api/find-by-series?series={series}

GET: /api/passport/find-expired

GET: /api/passport/find-replaceable

POST: /api/save/ + body with Passport

PUT: /api/update/ + body with Passport

DELETE: /api/passport/{id}