# Service App

## Description

`service-app` — Build an end-to-end system from request to response. The system contains 2 microservices. One for processing the request and the second one to log it.

- **service-shuffle**: Microservice to create a shuffled no-repeat int array;
- **service-log**: Microservice to log incoming request.

## Project structure

The project consists of two modules:

1. **service-shuffle** — a microservice that generates an array of random non-repeat shuffled numbers.
2. **service-log** —  a microservice that receives an array of numbers and logs it to console.

## Технологии

- Java 17
- Spring Boot 3.4.0
- Spring Web
- Maven
