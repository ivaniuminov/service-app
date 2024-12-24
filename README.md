# Service App

## Description

`service-app` — Build an end-to-end system from request to response. The system contains 2 microservices. One for processing the request and the second one to log it.

- **service-shuffle**: Microservice to create a shuffled no-repeat int array;
- **service-log**: Microservice to log incoming request.

## Project structure

The project consists of two modules:

1. **service-shuffle** — a microservice that generates an array of random non-repeat shuffled numbers.
2. **service-log** —  a microservice that receives an array of numbers and logs it to console.

## Technologies

- Java 17
- Spring Boot 3.4.0
- Spring Web
- Maven

## Examples:

1. **service-shuffle**: by default runs on 8080 port.

`POST http://localhost:8080/shuffle?length=10`
where length is a required query parameter to set the array length (from 1 to 1000 including).

2. **service-log**: by default runs on 8081 port.

`POST http://localhost:8081/log`
with request body as `[1,2,3,4,5]` - array to be logged.

**service-log** URL may be configured by the `service-log.base-url` application property in **service-shuffle**
