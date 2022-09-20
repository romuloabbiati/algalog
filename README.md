# Project Name: AlgaLog 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/romuloabbiati/algalog/blob/main/LICENSE) 

# About the project

AlgaLog is a back-end app (API Rest) built using Spring Boot during the **Spring Rest Especialist Week**, this event is organised by [AlgaWorks](https://www.algaworks.com/ "Site da AlgaWorks").

This application consists of a Delivery app which receives all the data related to an order like: customer who created the order, recipient, time when this order was created, so on and so forth. 

The order is tracked by the delivery status that can be PENDING, CANCELLED or DONE.

## Creating a new order
![Web 1](https://github.com/romuloabbiati/assets/blob/main/postman.jpg)

## UML model
![Modelo Conceitual](https://github.com/romuloabbiati/assets/blob/main/uml-projeto.jpg)

# Technologies used
## Back end
- Java 11
- Spring Boot
- JPA / Hibernate
- Maven
- Lombok
- ModelMapper
- Flyway

## Data persistence - Local DB
- MySQL

# How to run the project

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/romuloabbiati/algalog

# go to project's back end folder
cd backend

# run the application
./mvnw spring-boot:run
```

# Open PostMan
- Send HTTP requests to the end points below

## HTTP Request http://localhost:8080/customers
- POST To create
- GET To retrieve
- DELETE To delete
- PUT To update

## HTTP Request http://localhost:8080/deliveries
- POST To create
- GET To retrieve
- PUT To update the delivery status: PENDING > DONE
- OBS.: Can be cancelled only if the status is PENDING
  
## HTTP Request http://localhost:8080/deliveries/{id}/occurrences
- POST To create an occurrence (this will add a message to an delivery object, e.g. "delivery heading your way")

- GET To retrieve a list of occurrences of an delivery object

# Author

Rômulo Hipólito Abbiati

https://www.linkedin.com/in/romulo-hip%C3%B3lito-abbiati-73b9b696/?locale=en_US
